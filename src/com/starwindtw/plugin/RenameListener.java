package com.starwindtw.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameListener implements Listener {
    /*@EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        if (e.getView().getTitle().equals("§6自定義用戶名")) {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();

            player.sendMessage(player.getName());
            if (!e.getCurrentItem().getItemMeta().getDisplayName().equals(player.getName())){
                player.setDisplayName(ChatColor.DARK_RED + "");
                player.sendMessage(e.getCurrentItem().getItemMeta().getDisplayName());
            }
        }
    }*
    @EventHandler*/
    /*public void onPlayerRenameItem(PrepareAnvilEvent e){
        if (e.getResult() != null && e.getResult().hasItemMeta() && e.getInventory().getRenameText() != "") {
            Player player = (Player) e.getInventory().getHolder();
            Bukkit.getLogger().info(e.getResult().toString());
            e.getView().getPlayer().sendMessage("dwasdw","www");
            player.sendMessage("www");
            player.setDisplayName(ChatColor.DARK_RED + e.getInventory().getRenameText());
        }
        if (e.getResult() != null && e.getResult().hasItemMeta() && e.getInventory().getRenameText() != "") {
            Bukkit.getLogger().info(e.getResult().toString());
            ItemStack result = e.getResult();
            ItemMeta resultMeta = result.getItemMeta();
            String nameColored = ChatColor.translateAlternateColorCodes('&', e.getInventory().getRenameText());
            resultMeta.setDisplayName(nameColored);
            result.setItemMeta(resultMeta);
        }
    }*/
}