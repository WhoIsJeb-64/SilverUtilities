package com.flashbackmc.silverutilities;

import com.flashbackmc.silverutilities.commands.*;
import com.flashbackmc.silverutilities.listeners.PlayerChatListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.util.logging.Logger;

public class SilverUtilities extends JavaPlugin {
    private JavaPlugin plugin;
    private Logger log;
    private StaffChatHandler staffChatHandler;

    @Override
    public void onEnable() {
        plugin = this;
        log = this.getServer().getLogger();
        staffChatHandler = new StaffChatHandler();
        staffChatHandler.initializeToggleCache();

        setupConfig();
        registerCommands();
        registerListeners();

        log.info("Se ha cargado SilverUtilities!");
    }

    @Override
    public void onDisable() {
        log.info("Se ha descargado SilverUtilities!");
    }

    private void setupConfig() {
        this.getConfig().options().copyDefaults();
        this.saveDefaultConfig();
    }

    private void registerCommands() {
        getCommand("tellraw").setExecutor(new TellRawCommand(this));
        getCommand("fakeop").setExecutor(new FakeOpCommand(this));
        getCommand("staffchat").setExecutor(new StaffChatCommand(this, staffChatHandler));
        getCommand("discord").setExecutor(new DiscordCommand(this));
        getCommand("colorcodes").setExecutor(new ColorCodesCommand(this));
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerChatListener(this, staffChatHandler), this);
    }
}
