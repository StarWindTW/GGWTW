package com.starwindtw.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class professionCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Player p = (Player) sender;
        if (sender instanceof Player){
            if(args.length == 0){
                p.performCommand("profession menu");
                return true;
            } else if (args.length >= 1) {
                if(args[0].equals("help")){
                    p.sendMessage("-------------------------");
                    p.sendMessage("/profession menu --開啟職業選擇選單");
                    p.sendMessage("/profession confirm <profession> --開啟指定職業選擇確認選單");
                    p.sendMessage("/profession set <Player> <profession> --設定玩家職業");
                    p.sendMessage("-------------------------");
                }
                if (args[0].equals("menu")) {
                    Inventory GUI = Bukkit.createInventory(null, 54, "§0職業選擇");

                    ItemStack Thieves = new ItemStack(Material.IRON_SWORD, 1);
                    ItemMeta ThievesMeta = Thieves.getItemMeta();
                    ThievesMeta.setDisplayName("§4盜賊");
                    ThievesMeta.setLore(new ArrayList<>(Arrays.asList("§7在夜黑風高的夜晚", "§7殺戮的利刃悄然出鞘", "§7隱蔽自身的氣息", "§7潛入基地直取敵方首級", "§7使敵人死於黑暗的恐懼之中", " ","§4§o暗殺便是盜賊的天性", "§4§o隱蔽便是盜賊的天賦", " ")));
                    ThievesMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                    Thieves.setItemMeta(ThievesMeta);

                    ItemStack Wizard = new ItemStack(Material.STICK, 1);
                    ItemMeta WizardMeta = Wizard.getItemMeta();
                    WizardMeta.setDisplayName("§b法師");
                    Wizard.setItemMeta(WizardMeta);

                    GUI.setItem(10, Thieves);
                    GUI.setItem(12, Wizard);
                    ((Player) sender).openInventory(GUI);
                    return true;
                }
                if (args[0].equals("confirm")) {
                    if (args[1].equals("Thieves")) {
                        Inventory GUI = Bukkit.createInventory(null, 54, "§4盜賊");

                        ItemStack Thieves = new ItemStack(Material.IRON_SWORD);
                        ItemMeta ThievesMeta = Thieves.getItemMeta();
                        ThievesMeta.setDisplayName("§4盜賊");
                        ThievesMeta.setLore(new ArrayList<>(Arrays.asList("§7血量: 14 ❤","§7魔力: 16","§7基礎攻擊力: 8")));
                        ThievesMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        Thieves.setItemMeta(ThievesMeta);

                        ItemStack lvl60 = new ItemStack(Material.IRON_SWORD);
                        ItemMeta lvl60Meta = lvl60.getItemMeta();
                        lvl60Meta.setDisplayName("§4大盜賊");
                        lvl60Meta.setLore(new ArrayList<>(Arrays.asList("§7在§660§7級時能夠轉職為大盜賊")));
                        lvl60Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        lvl60.setItemMeta(lvl60Meta);

                        ItemStack lvl120 = new ItemStack(Material.IRON_SWORD);
                        ItemMeta lvl120Meta = lvl120.getItemMeta();
                        lvl120Meta.setDisplayName("§4影舞盜賊");
                        lvl120Meta.setLore(new ArrayList<>(Arrays.asList("§7在§6120§7級時能夠轉職為影舞盜賊")));
                        lvl120Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        lvl120.setItemMeta(lvl120Meta);

                        ItemStack Confirm = new ItemStack(Material.GREEN_STAINED_GLASS);
                        ItemMeta ConfirmMeta = Confirm.getItemMeta();
                        ConfirmMeta.setDisplayName("§a確認選擇盜賊");
                        Confirm.setItemMeta(ConfirmMeta);

                        ItemStack Cancel = new ItemStack(Material.RED_STAINED_GLASS);
                        ItemMeta CancelMeta = Cancel.getItemMeta();
                        CancelMeta.setDisplayName("§c選擇其他職業");
                        Cancel.setItemMeta(CancelMeta);

                        GUI.setItem(4, Thieves);
                        GUI.setItem(21, lvl60);
                        GUI.setItem(23, lvl120);
                        GUI.setItem(38, Confirm);
                        GUI.setItem(42, Cancel);
                        ((Player) sender).openInventory(GUI);
                        return true;
                    }
                    if (args[1].equals("Wizard")) {
                        Inventory GUI = Bukkit.createInventory(null, 54, "§b法師");

                        ItemStack Wizard = new ItemStack(Material.STICK);
                        ItemMeta WizardMeta = Wizard.getItemMeta();
                        WizardMeta.setDisplayName("§b法師");
                        WizardMeta.setLore(new ArrayList<>(Arrays.asList("§7在夜黑風高的夜晚", "§7殺戮的利刃悄然出鞘", "§7隱蔽自身的氣息", "§7潛入基地直取敵方首級", "§7使敵人死於黑暗的恐懼之中", " ","§4§o暗殺便是盜賊的天性", "§4§o隱蔽便是盜賊的天賦", " ")));
                        WizardMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        Wizard.setItemMeta(WizardMeta);

                        ItemStack lvl60 = new ItemStack(Material.STICK);
                        ItemMeta lvl60Meta = lvl60.getItemMeta();
                        lvl60Meta.setDisplayName("§b大法師");
                        lvl60Meta.setLore(new ArrayList<>(Arrays.asList("§7在§660§7級時能夠轉職為大法師")));
                        lvl60Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        lvl60.setItemMeta(lvl60Meta);

                        ItemStack lvl120 = new ItemStack(Material.STICK);
                        ItemMeta lvl120Meta = lvl120.getItemMeta();
                        lvl120Meta.setDisplayName("§b魔導師");
                        lvl120Meta.setLore(new ArrayList<>(Arrays.asList("§7在§6120§7級時能夠轉職為魔導師")));
                        lvl120Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                        lvl120.setItemMeta(lvl120Meta);

                        ItemStack Confirm = new ItemStack(Material.GREEN_STAINED_GLASS);
                        ItemMeta ConfirmMeta = Confirm.getItemMeta();
                        ConfirmMeta.setDisplayName("§a確認選擇法師");
                        Confirm.setItemMeta(ConfirmMeta);

                        ItemStack Cancel = new ItemStack(Material.RED_STAINED_GLASS);
                        ItemMeta CancelMeta = Cancel.getItemMeta();
                        CancelMeta.setDisplayName("§c選擇其他職業");
                        Cancel.setItemMeta(CancelMeta);

                        GUI.setItem(4, Wizard);
                        GUI.setItem(21, lvl60);
                        GUI.setItem(23, lvl120);
                        GUI.setItem(38, Confirm);
                        GUI.setItem(42, Cancel);
                        ((Player) sender).openInventory(GUI);
                        return true;
                    }
                }
            }
            return true;
        }else{
            sender.sendMessage("此指令只能由玩家執行");
        }
        return false;
    }
}
