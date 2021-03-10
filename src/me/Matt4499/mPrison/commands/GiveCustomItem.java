package me.Matt4499.mPrison.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Matt4499.mPrison.implementations.mKit;

public class GiveCustomItem implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        if (sender.hasPermission("mPrison.givecustomitems")) {
            if(args[1].equalsIgnoreCase("ArrestStick")) {
                mKit.giveArrestStick((Player) sender);
            }
            if(args[1].equalsIgnoreCase("BasicGuardSword")) {
                mKit.giveBasicGuardSword((Player) sender);
            }
            return true;
        } else {
            return false;
        }
    }

}
