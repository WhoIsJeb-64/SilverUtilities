package com.flashbackmc.silverutilities.commands;

import com.flashbackmc.silverutilities.SilverUtilities;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ColorCodesCommand implements CommandExecutor {
    private final SilverUtilities plugin;

    public ColorCodesCommand(SilverUtilities plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage("§0&0 - Black           §1&1 - Dark Blue");
        commandSender.sendMessage("§2&2 - Dark Green   §3&3 - Dark Aqua");
        commandSender.sendMessage("§4&4 - Dark Red      §5&5 - Dark Purple");
        commandSender.sendMessage("§6&6 - Gold            §7&7 - Gray");
        commandSender.sendMessage("§8&8 - Dark Gray     §9&9 - Blue");
        commandSender.sendMessage("§a&a - Green          §b&b - Aqua");
        commandSender.sendMessage("§c&c - Red             §d&d - Magenta");
        commandSender.sendMessage("§e&e - Yellow          §f&f - White");
        return true;
    }
}
