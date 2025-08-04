package com.flashbackmc.silverutilities.listeners;

import com.flashbackmc.silverutilities.SilverUtilities;
import com.flashbackmc.silverutilities.StaffChatHandler;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerChatListener implements Listener {
    private final SilverUtilities plugin;
    private final StaffChatHandler handler;

    public PlayerChatListener(SilverUtilities plugin, StaffChatHandler handler) {
        this.plugin = plugin;
        this.handler = handler;
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerChat(final PlayerChatEvent event) {
        if (handler.isStaffChatToggled(event.getPlayer().getName())) {
            Bukkit.getServer().dispatchCommand(event.getPlayer(), "staffchat " + event.getMessage());
            event.setCancelled(true);
        }
    }
}
