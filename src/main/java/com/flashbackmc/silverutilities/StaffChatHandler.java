package com.flashbackmc.silverutilities;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import java.util.ArrayList;

public class StaffChatHandler {
    private ArrayList<String> toggleCache;

    public String buildMessage(FileConfiguration config, CommandSender commandSender, String[] strings) {
        String tag = config.getString("settings.staffchat.tag");
        String name = commandSender.getName();
        String prefix = config.getString("settings.staffchat.user-prefixes." + name);
        String delimiter = config.getString("settings.staffchat.delimiter");
        ChatColor color = ChatColor.valueOf(config.getString("settings.staffchat.color"));
        String message = String.join(" ", strings);

        String fullMessage = tag + prefix + name + delimiter + color + message;
        fullMessage = fullMessage.replaceAll("&", "§");
        return fullMessage;
    }

    public void initializeToggleCache() {
        this.toggleCache = new ArrayList<>();
    }

    public void toggleStaffChat(Player player) {
        String name = player.getName();
        if (toggleCache.contains(name)) {
            toggleCache.remove(name);
            player.sendMessage("§cStaffchat toggled off!");
        } else {
            toggleCache.add(name);
            player.sendMessage("§cStaffchat toggled on!");
        }
    }

    public boolean isStaffChatToggled(String name) {
        return toggleCache.contains(name);
    }
}
