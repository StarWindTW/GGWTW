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

public class GuildCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (sender instanceof Player){
            if (args.length == 0){
                p.performCommand("guild menu");

                return true;
            } else if (args.length >=1) {
                if(args[0].equals("menu")){
                    Inventory GUI = Bukkit.createInventory(null, 54, "§6公會選單");

                    ItemStack CreateGuild = new ItemStack(Material.MAGENTA_TERRACOTTA, 1);
                    ItemMeta CreateGuildMeta = CreateGuild.getItemMeta();
                    CreateGuildMeta.setDisplayName("§b創建公會");
                    CreateGuild.setItemMeta(CreateGuildMeta);

                    GUI.setItem(22, CreateGuild);

                    ((Player) sender).openInventory(GUI);
                    return true;
                }
                if(args[0].equals("help")){
                    p.sendMessage("-------------------------");
                    p.sendMessage("/guild menu --開啟公會選單");
                    p.sendMessage("/guild create <name> --創建公會");
                    p.sendMessage("-------------------------");
                    return true;
                }
                if(args[0].equals("create")){
                    p.sendMessage("create");
                    return true;
                }
            }
        }else{
            sender.sendMessage("此指令只能由玩家執行");
        }
        return false;
    }
}
