package me.Matt4499.mPrison.implementations;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import me.Matt4499.mPrison.Main;

public class mUser {

    private Player player;
    private Boolean afk = false;
    private String team = null;

    public mUser(Player player) {
        this.player = player;
    }

    public Boolean isAfk() {
        return this.afk;
    }

    public Boolean setAFK() {
        this.afk = !this.afk;
        return this.afk;
    }

    public Boolean isGuard() {
        return this.team == "guard" ? true : false;
    }

    public void setGuard() {
        if(this.isGuard()) {
            Main.consoleLogColor(ChatColor.RED, "[mPrison] [mUser:" + this.getPlayerName() + "] Tried to set guard when they are already guard?");
            return;
        }
        // TODO check if player is banned from being a guard
        this.team = "guard";
        this.player.teleport(Main.guardSpawn);
    }

    public boolean isPrisoner() {
        return this.team == "prisoner" ? true : false;
    }

    public void setPrisoner() {
        if(this.isPrisoner() || Main.prisoners.containsKey(this.player)) {
            Main.consoleLogColor(ChatColor.RED, "[mPrison] [mUser:" + this.getPlayerName() + "] Tried to set prisoner when they are already prisoner?");
            return;
        }
        this.team = "prisoner";
        this.player.teleport(Main.prisonerSpawn);
        Main.prisoners.put(this.player, this);
    }

    public void resetPlayerSession() {
        this.team = null;
        this.player.teleport(Main.spawn);
        Main.prisoners.remove(this.player);
        Main.guards.remove(this.player);
    }

    public String getPlayerName() {
        return this.player.getName();
    }

    public String getDisplayName() {
        return this.player.getDisplayName();
    }

    public void systemMessage(String text) {
        this.player.sendMessage(ChatColor.GRAY + "[System] " + text);
    }

    public void judgeMessage(String text) {
        this.player.sendMessage(ChatColor.GOLD + "[Judge] " + text);
    }

}
