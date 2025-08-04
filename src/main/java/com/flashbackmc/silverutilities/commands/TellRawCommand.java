package com.flashbackmc.silverutilities.commands;

import com.flashbackmc.silverutilities.SilverUtilities;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TellRawCommand implements CommandExecutor {

    public TellRawCommand(SilverUtilities silverUtilities) {
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String message = String.join(" ", strings);
        message = message.replaceAll("&", "§");
        Bukkit.getServer().broadcastMessage(message);
        return true;
    }
}
