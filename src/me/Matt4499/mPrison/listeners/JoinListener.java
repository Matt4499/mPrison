package me.Matt4499.mPrison.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.Matt4499.mPrison.Main;
import me.Matt4499.mPrison.implementations.mUser;

public class JoinListener implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(!player.isWhitelisted() && Bukkit.hasWhitelist() || player.isBanned()) { return; }
        if(!Main.mUsers.containsKey(player)) {
            Main.mUsers.put(event.getPlayer(), new mUser(event.getPlayer()));
        } else {
            Main.consoleLogColor(ChatColor.RED, "[mPrison] [JoinListener] " + event.getPlayer().getName() + " was already on the online players list?");
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(Main.mUsers.containsKey(player)) {
            Main.mUsers.remove(player);
        } else {
            Main.consoleLogColor(ChatColor.RED, "[mPrison] [JoinListener] " + event.getPlayer().getName() + " was not on the online players list?");
        }
    }
    
}
