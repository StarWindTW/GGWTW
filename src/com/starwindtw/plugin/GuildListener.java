package com.starwindtw.plugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class GuildListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equals("§6公會選單")){
            e.setCancelled(true);
            if(e.getCurrentItem() == null){
                return;
            }
            if(e.getCurrentItem().getItemMeta().getDisplayName().equals("§b創建公會")){
                p.sendMessage("w");
            }
        }
    }
}
