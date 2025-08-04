package com.flashbackmc.silverutilities.commands;

import com.flashbackmc.silverutilities.SilverUtilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DiscordCommand implements CommandExecutor {
    private final SilverUtilities plugin;

    public DiscordCommand(SilverUtilities plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        String message = plugin.getConfig().getString("messages.discord");
        message = message.replaceAll("&", "§");
        commandSender.sendMessage(message);
        return true;
    }
}
