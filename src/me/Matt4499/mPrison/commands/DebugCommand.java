package me.Matt4499.mPrison.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.Matt4499.mPrison.Main;

public class DebugCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] arg3) {
        if(sender.hasPermission("mPrison.debug")) {
            sender.sendMessage("Prisoners: " + Main.prisoners.toString());
            sender.sendMessage("Guards: " + Main.guards.toString());
            return true;
        } else {
            sender.sendMessage("No permission!");
            return false;
        }
    }
    
}
