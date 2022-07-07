package com.starwindtw.plugin;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    private static Main plugin;
    @Override
    public void onEnable(){
        plugin = this;
        FileConfiguration config = this.getConfig();
        config.addDefault("welcome_message", "歡迎進入星風伺服器");
        config.options().copyDefaults(true);
        saveConfig();
        getLogger().info("Hello World");
        getCommand("web").setExecutor(new WebCommand());
        getCommand("food").setExecutor(new KitCommand());
        getCommand("menu").setExecutor(new MenuCommand());
        getCommand("rename").setExecutor(new RenameCommand());
        professionselect();
        guild();
        online();
        getServer().getPluginManager().registerEvents(new RenameListener(), this);
        getServer().getPluginManager().registerEvents(new MenuListener(), this);
        getServer().getPluginManager().registerEvents(new EventListener(this), this);
        getServer().getPluginManager().registerEvents(new ScoreBoardListener(),this);ScoreBoardListener sb = new ScoreBoardListener();
        if(!Bukkit.getOnlinePlayers().isEmpty()){
            for(Player online : Bukkit.getOnlinePlayers()){
                sb.CreateBoard(online);
                sb.Start(online);
            }
        }
    }
    public void professionselect(){
        getCommand("profession").setExecutor(new professionCommand());
        getCommand("profession").setTabCompleter(new professionTab());
        getServer().getPluginManager().registerEvents(new professionListener(), this);
    }
    public void guild(){
        getCommand("guild").setExecutor(new GuildCommand());
        getCommand("guild").setTabCompleter(new GuildTab());
        getServer().getPluginManager().registerEvents(new GuildListener(), this);
    }
    public void online(){
        getCommand("online").setExecutor(new OnlineCommand());
        getServer().getPluginManager().registerEvents(new OnlineListener(), this);
    }
    public static Main getPlugin() {
        return plugin;
    }
}
