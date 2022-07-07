package com.starwindtw.plugin;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.scoreboard.Team;

public class MenuListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player player = (Player) e.getWhoClicked();
        if(e.getCurrentItem() == null){
            return;
        }
        if (e.getView().getTitle().equals("§0伺服器選單")){
            e.setCancelled(true);
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§d領取美味牛排")){
                player.closeInventory();
                player.performCommand("food");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6個人資料")){
                player.closeInventory();
                player.setDisplayName(ChatColor.DARK_RED + player.getName());
                player.setPlayerListName(ChatColor.DARK_RED + player.getName());
                player.sendMessage("www");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§d公會")){
                player.performCommand("guild");
                player.sendMessage("guild");
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§d在線玩家")){
                player.performCommand("online");
                player.sendMessage("online");
            }
        }
    }
}
