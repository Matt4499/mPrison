package me.Matt4499.mPrison.listeners;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import me.Matt4499.mPrison.Main;
import me.Matt4499.mPrison.implementations.mUser;

public class SignClickListener implements Listener {
    @EventHandler
    public void onSignClick(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        if(event.getClickedBlock() == null || !event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) return;
        if(event.getClickedBlock().getType() == Material.OAK_SIGN || event.getClickedBlock().getType() == Material.OAK_WALL_SIGN) {
            if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                Sign sign = (Sign) event.getClickedBlock().getState();
                if(sign.getLine(0).equalsIgnoreCase("[prisoner]")) {
                    mUser player = Main.mUsers.get(p);
                    if(player.isPrisoner()) {
                        p.sendMessage("[Error] You are already a prisoner.");
                        return;
                    }  else {
                        player.setPrisoner();
                        player.judgeMessage("You have been sentenced for 25 to life!");
                    }
                }
                if(sign.getLine(0).equalsIgnoreCase("[guard]")) {
                    mUser player = Main.mUsers.get(p);
                    if(player.isGuard()) {
                        p.sendMessage("[Error] You are already a guard.");
                        return;
                    }  else {
                        player.setGuard();
                        player.systemMessage("You are now on duty!");
                        // TODO give basic guard kit
                    }
                }
            }
        }
    }
    
}
