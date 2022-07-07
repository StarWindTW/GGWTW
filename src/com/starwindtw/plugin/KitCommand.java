package com.starwindtw.plugin;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class KitCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (args.length == 0) {
            if (sender instanceof Player){
                Player player = (Player) sender;
                ItemStack food = new ItemStack(Material.COOKED_BEEF, 64);
                ItemMeta itemMeta = food.getItemMeta();
                itemMeta.setDisplayName("§2美味牛排");
                itemMeta.setLore(new ArrayList<>(Arrays.asList("第一行", "第二行")));
                food.setItemMeta(itemMeta);
                player.getInventory().addItem(food);
                return true;
            }
        }
        return false;
    }
}