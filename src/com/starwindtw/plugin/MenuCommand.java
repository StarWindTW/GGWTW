package com.starwindtw.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player){
            Inventory GUI = Bukkit.createInventory(null, 54, "§0伺服器選單");

            ItemStack kitButton = new ItemStack(Material.COOKED_BEEF, 1);
            ItemMeta itemMeta = kitButton.getItemMeta();
            itemMeta.setDisplayName("§d領取美味牛排");
            kitButton.setItemMeta(itemMeta);

            ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
            SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
            skullMeta.setDisplayName("§6個人資料");
            skullMeta.setOwnerProfile(player.getPlayerProfile());
            skull.setItemMeta(skullMeta);

            ItemStack guild = new ItemStack(Material.EMERALD, 1);
            ItemMeta guildMeta = guild.getItemMeta();
            guildMeta.setDisplayName("§d公會");
            guild.setItemMeta(guildMeta);

            ItemStack online = new ItemStack(Material.EMERALD, 1);
            ItemMeta onlineMeta = online.getItemMeta();
            onlineMeta.setDisplayName("§d在線玩家");
            online.setItemMeta(onlineMeta);

            for(int i = 9;i < 18; i++){
                ItemStack placeholder = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
                ItemMeta placeholderMeta = placeholder.getItemMeta();
                placeholderMeta.setDisplayName(" ");
                placeholder.setItemMeta(placeholderMeta);
                GUI.setItem(i, placeholder);
            }

            GUI.setItem(0, kitButton);
            GUI.setItem(3, guild);
            GUI.setItem(4, skull);
            GUI.setItem(5, online);
            ((Player) sender).openInventory(GUI);
        }else{
            sender.sendMessage("此指令只能由玩家執行");
        }
        return false;
    }
}
