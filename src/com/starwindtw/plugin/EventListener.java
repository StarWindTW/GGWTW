package com.starwindtw.plugin;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLevelChangeEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;

public class EventListener implements Listener {
    Main plugin;
    public EventListener(Main instance){
        plugin = instance;
    }
    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();

        p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(plugin.getConfig().getString("welcome_message")));

        PersistentDataContainer data = p.getPersistentDataContainer();
        if(!data.has(new NamespacedKey(Main.getPlugin(), "vault"), PersistentDataType.STRING)){
            data.set(new NamespacedKey(Main.getPlugin(), "vault"), PersistentDataType.STRING, "");
        }

    }
    @EventHandler
    public void levelup(PlayerLevelChangeEvent e){
        Player p = e.getPlayer();
        if(e.getNewLevel() == 30){
            p.sendTitle(ChatColor.translateAlternateColorCodes('&',"恭喜等級達到30級"),"可以進行轉職任務了",5,35,3);
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0f, 1.0f);
        }else if(e.getNewLevel() > e.getOldLevel()){
            p.sendTitle(ChatColor.translateAlternateColorCodes('&',"等級提升"),e.getOldLevel() +" 升級為 " + e.getNewLevel(),5,35,3);
            p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 2.0f, 1.0f);
        }else{
            p.sendTitle(ChatColor.translateAlternateColorCodes('&',"等級下降"),e.getOldLevel() +" 降級為 " + e.getNewLevel(),5,35,3);
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_DESTROY, 2.0f, 1.0f);
        }
    }
}
