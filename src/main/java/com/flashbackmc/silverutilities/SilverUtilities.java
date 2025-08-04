package com.flashbackmc.silverutilities;

import com.flashbackmc.silverutilities.commands.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;
import java.util.logging.Logger;

public class SilverUtilities extends JavaPlugin {
    private JavaPlugin plugin;
    private Logger log;
    private final File configFile = new File(getDataFolder(), "config.yml");
    private FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

    @Override
    public void onEnable() {
        plugin = this;
        log = this.getServer().getLogger();

        if (!configFile.exists()) {
            saveResource("config.yml", false);
            log.info("Created SilverUtilities config!");
        }
        config = YamlConfiguration.loadConfiguration(getResource("config.yml"));
        registerCommands();
        registerListeners();

        log.info("SilverUtilities has loaded!");
    }

    @Override
    public void onDisable() {
        log.info("SilverUtilities has unloaded!");
    }

    private void registerCommands() {
        getCommand("tellraw").setExecutor(new TellRawCommand(this));
        getCommand("fakeop").setExecutor(new FakeOpCommand(this));
        getCommand("discord").setExecutor(new DiscordCommand(this));
    }

    private void registerListeners() {
        //
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public File getConfigFile() {
        return configFile;
    }
}
