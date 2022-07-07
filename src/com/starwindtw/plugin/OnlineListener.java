package com.starwindtw.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.AnvilInventory;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Type;

public class OnlineListener implements Listener {
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e){
        Player p = (Player) e.getWhoClicked();
        if(e.getView().getTitle().contains("個人資料")){
            e.setCancelled(true);
        }
        if(e.getInventory().getType() == InventoryType.ANVIL && e.getView().getTitle().equals("§7搜尋玩家")){
            e.setCancelled(true);
            Inventory a = e.getInventory();
            if(e.getSlotType() == InventoryType.SlotType.RESULT) {
                p.sendMessage("HelloWorld");
                p.sendMessage("");
                p.performCommand("online open " + e.getResult());
            }
        }
        if (e.getView().getTitle().equals("§0在線玩家(" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")")){
            e.setCancelled(true);
            if(e.getCurrentItem() == null){
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§7搜尋")){
                e.setCancelled(true);
                Inventory GUI = Bukkit.createInventory(null, InventoryType.ANVIL, "§7搜尋玩家");

                ItemStack original = new ItemStack(Material.PAPER, 1);
                ItemMeta originalMeta = original.getItemMeta();
                originalMeta.setDisplayName("");
                original.setItemMeta(originalMeta);

                GUI.setItem(0, original);

                ((Player) p).openInventory(GUI);
            }else if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§a下一頁")){
                e.setCancelled(true);
            }else{
                p.performCommand("online open " + e.getCurrentItem().getItemMeta().getDisplayName());
            }
        }
    }
}
