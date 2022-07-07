package com.starwindtw.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player){
            Inventory GUI = Bukkit.createInventory(null, InventoryType.ANVIL, "§6自定義用戶名");

            ItemStack original = new ItemStack(Material.PAPER, 1);
            ItemMeta originalMeta = original.getItemMeta();
            originalMeta.setDisplayName(player.getDisplayName());
            original.setItemMeta(originalMeta);

            GUI.setItem(0, original);

            ((Player) sender).openInventory(GUI);
        }else{
            sender.sendMessage("此指令只能由玩家執行");
        }
        return false;
    }
}