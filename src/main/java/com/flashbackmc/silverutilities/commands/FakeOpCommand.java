package com.flashbackmc.silverutilities.commands;

import com.flashbackmc.silverutilities.SilverUtilities;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FakeOpCommand implements CommandExecutor {
    private final SilverUtilities plugin;

    public FakeOpCommand(SilverUtilities plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) throws CommandException {
        if (strings.length < 1) {
            commandSender.sendMessage("§cSyntax: /fakeop <player>");
            return true;
        }

        String victimName = strings[0];
        Player victim = Bukkit.getPlayer(victimName);

        try {
            victim.sendMessage("§eYou are now op!");
            Bukkit.getLogger().info(commandSender.getName() + " fake opped " + victimName + ".");
        } catch (Exception e) {
            commandSender.sendMessage("§cThe victim must be online!");
        }
        return true;
    }
}
