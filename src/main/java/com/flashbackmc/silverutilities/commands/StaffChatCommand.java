package com.flashbackmc.silverutilities.commands;

import com.flashbackmc.silverutilities.SilverUtilities;
import com.flashbackmc.silverutilities.StaffChatHandler;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChatCommand implements CommandExecutor {
    private final SilverUtilities plugin;
    private final StaffChatHandler handler;

    public StaffChatCommand(SilverUtilities plugin, StaffChatHandler handler) {
        this.plugin = plugin;
        this.handler = handler;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length == 0) {
            handler.toggleStaffChat((Player) commandSender);
            return true;
        }
        String message = handler.buildMessage(plugin.getConfig(), commandSender, strings);

        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("silverutilities.staffchat.read") || player.isOp()) {
                player.sendMessage(message);
            }
        }
        return true;
    }
}
