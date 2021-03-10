package me.Matt4499.mPrison.implementations;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import me.Matt4499.mPrison.Main;
import me.Matt4499.mPrison.utils.Contraband;

public class mArrestMenu implements Listener {

    public static Inventory arrestGUI;
    public static ItemStack arrestButton = new ItemStack(Material.IRON_BARS);

    @EventHandler
    public void onPlayerHit(EntityDamageByEntityEvent event) {
        Main.consoleLog("player hit");
        if(event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Main.consoleLog("player player");
            Player player = (Player) event.getEntity(); 
            Player attacker = (Player) event.getDamager();
            Main.consoleLog(attacker + " hit " + player);
            if(attacker.getInventory().getItemInMainHand().getType() == Material.STICK) {
                Main.consoleLog("player arrest stick");
                // A guard has hit a prisoner with an arrest stick
                Main.arrests.put(attacker, player);
                player.sendMessage("[Debug] you are being arrested by: " + attacker.getName());
                attacker.sendMessage("[Debug] you are arresting: " + player.getName());
                attacker.openInventory(getArrestGUI());
            }
        }
    } 

    public static void init() {
        arrestGUI = Bukkit.createInventory(null, 9, "Arrest Menu");
        arrestGUI.addItem(arrestButton);
    }

    public Inventory getArrestGUI() {
        return arrestGUI;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if(event.getView().getTitle().equals("Arrest Menu")) { // If the inventory is *actually* the arrest menu
            if(event.getView().getItem(event.getSlot()) == arrestButton) { // If the clicked item is the arrest button
                if(Main.guards.containsKey((Player) event.getWhoClicked())) { // if a *guard* clicked the arrest button
                    // send prisoner back to their cell and clear all contraband in their inventory
                    Player prisoner = Main.arrests.get((Player) event.getWhoClicked());
                    Contraband.clearContrabandFromPlayer(prisoner, (Player) event.getWhoClicked());
                    Main.arrests.remove((Player) event.getWhoClicked());
                }
            } 
        }
    }

    
    
}
