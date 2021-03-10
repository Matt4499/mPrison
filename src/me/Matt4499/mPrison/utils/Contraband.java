package me.Matt4499.mPrison.utils;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Matt4499.mPrison.Main;
import me.Matt4499.mPrison.implementations.mUser;

public class Contraband {

    public static void clearContrabandFromPlayer(Player player, Player guard) {
        Main.consoleLogColor(ChatColor.GREEN, "[mPrison] [Utils:clearContrabandFromPlayer:" + player.getName() + "] Removing all contraband from this player");
        int contrabandCount = 0;
        for(ItemStack item : player.getInventory().getContents()) {
            ItemMeta itemmeta = item.getItemMeta();
            List<String> itemlore = itemmeta.getLore();
            for(String loreLine : itemlore) {
                if(loreLine.contains("Contraband")) {
                    player.getInventory().remove(item);
                    contrabandCount++;
                }
            }
        }
        if(contrabandCount == 0) {
            mUser mUserGuard = Main.guards.get(guard);
            mUserGuard.systemMessage(player.getName() + " did not have any contraband."); 
        } else {
            mUser mUserGuard = Main.guards.get(guard);
            mUserGuard.systemMessage(player.getName() + " had " + contrabandCount + " pieces of contraband.");
        }
    }
    
}
