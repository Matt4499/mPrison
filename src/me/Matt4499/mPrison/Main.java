package me.Matt4499.mPrison;

import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;

import me.Matt4499.mPrison.commands.DebugCommand;
import me.Matt4499.mPrison.commands.GiveCustomItem;
import me.Matt4499.mPrison.implementations.mArrestMenu;
import me.Matt4499.mPrison.implementations.mEconomy;
import me.Matt4499.mPrison.implementations.mKit;
import me.Matt4499.mPrison.implementations.mUser;
import me.Matt4499.mPrison.listeners.JoinListener;
import me.Matt4499.mPrison.listeners.SignClickListener;
import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin {

    public static Map<Player, mUser> mUsers = new HashMap<Player, mUser>();
    public static Map<Player, mUser> guards = new HashMap<Player, mUser>();
    public static Map<Player, mUser> prisoners = new HashMap<Player, mUser>();
    public static Map<Player, Player> arrests = new HashMap<Player, Player>();
    public static Location guardSpawn = new Location(Bukkit.getServer().getWorld("world"), 4991, 189, 4990);
    public static Location prisonerSpawn = new Location(Bukkit.getServer().getWorld("world"), 4991, 189, 5009);
    public static Location spawn = new Location(Bukkit.getServer().getWorld("world"), 5000, 189, 5000);


    @Override
    public void onEnable() {
        consoleLog("[mPrison] [Main] Initializing mPrison");
        consoleLog("[mPrison] [Main] Hooking vault economy...");
        if(Bukkit.getServer().getPluginManager().getPlugin("Vault") != null) {
            Bukkit.getServer().getServicesManager().register(Economy.class, new mEconomy(), this, ServicePriority.Highest);
            consoleLogColor(ChatColor.GREEN, "[mPrison] [Main] Registered Economy Class!");
        } else {
            consoleLogColor(ChatColor.RED, "[mPrison] [Main] Vault was not found. Disabling plugin...");
            Bukkit.getPluginManager().disablePlugin(this);
        }
        consoleLog("[mPrison] [Main] Registering listeners and commands...");
        Bukkit.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        consoleLogColor(ChatColor.GREEN, "[mPrison] [Main] Registered: JoinListener");
        Bukkit.getServer().getPluginManager().registerEvents(new SignClickListener(), this);
        consoleLogColor(ChatColor.GREEN, "[mPrison] [Main] Registered: SignClickListener");
        this.getCommand("mprisondebug").setExecutor(new DebugCommand());
        consoleLogColor(ChatColor.GREEN, "[mPrison] [Main] Registered: GiveCustomItem");
        this.getCommand("givecustomitem").setExecutor(new GiveCustomItem());
        consoleLogColor(ChatColor.GREEN, "[mPrison] [Main] Registered: mArrestMenu");
        Bukkit.getServer().getPluginManager().registerEvents(new mArrestMenu(), this);

        mKit.init();

    }

    @Override
    public void onDisable() {
        // TODO save data on shutdown/disable
    }

    public static void consoleLog(String text) {
        Bukkit.getServer().getConsoleSender().sendMessage(text);
    }

    public static void consoleLogColor(ChatColor color, String text) {
        Bukkit.getServer().getConsoleSender().sendMessage(color + text);
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }
    
}
