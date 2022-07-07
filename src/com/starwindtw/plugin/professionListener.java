package com.starwindtw.plugin;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class professionListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equals("§0職業選擇")) {
            e.setCancelled(true);
            if(e.getCurrentItem() == null){
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4盜賊")){
                p.performCommand("profession confirm Thieves");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§b法師")){
                p.performCommand("profession confirm Wizard");
            }
        }
        if (e.getView().getTitle().equals("§4盜賊")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c選擇其他職業")){
                p.performCommand("profession open");
            }
        }
        if (e.getView().getTitle().equals("§b法師")) {
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§c選擇其他職業")){
                p.performCommand("profession open");
            }
        }
    }
}
