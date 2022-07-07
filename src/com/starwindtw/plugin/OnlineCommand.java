package com.starwindtw.plugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.bukkit.Bukkit.getServer;

public class OnlineCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        long now = System.currentTimeMillis() / 1000;
        final long millisecondsPerDay = 1000 * 60 * 60 * 24;
        if (sender instanceof Player) {
            if (args.length == 0){
                Inventory GUI = Bukkit.createInventory(null, 54, "§0在線玩家(" + Bukkit.getOnlinePlayers().size() + "/" + Bukkit.getMaxPlayers() + ")");

                List<String> players = new ArrayList<String>();

                for (Player online : getServer().getOnlinePlayers()) {
                    players.add(online.getName());
                }
                ItemStack next= new ItemStack(Material.ARROW, 1);
                ItemMeta nextMeta = next.getItemMeta();
                nextMeta.setDisplayName("§a下一頁");
                next.setItemMeta(nextMeta);

                ItemStack search= new ItemStack(Material.GUNPOWDER, 1);
                ItemMeta searchMeta = search.getItemMeta();
                searchMeta.setDisplayName("§7搜尋");
                search.setItemMeta(searchMeta);
                for (int i = 0; i < players.size(); i++) {
                    if(i>44){
                        break;
                    }
                    Player p = Bukkit.getPlayer(players.get(i));
                    ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
                    SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
                    skullMeta.setDisplayName("§r" + p.getName());
                    skullMeta.setOwnerProfile(p.getPlayerProfile());
                    skullMeta.setLore(new ArrayList<>(Arrays.asList("§7名稱: " + p.getDisplayName(), "§7等級: " + "§b" + p.getLevel(), "§7職業: ", "§7公會: ", " ", "§7點擊查看詳情")));
                    skull.setItemMeta(skullMeta);

                    GUI.setItem(i, skull);
                }
                GUI.setItem(49, search);
                GUI.setItem(53, next);
                ((Player) sender).openInventory(GUI);
                return true;
            } else if (args.length >= 1) {
                if(args[0].equals("open")){
                    if(!args[1].isEmpty()){

                        UUID bffUuid = getServer().getOfflinePlayer(args[1]).getUniqueId();

                        OfflinePlayer p = Bukkit.getOfflinePlayer(bffUuid);
                        Inventory GUI = Bukkit.createInventory(null, 54, "§0" + p.getName() + " 個人資料");

                        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
                        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
                        skullMeta.setDisplayName("§r" + p.getName());
                        skullMeta.setOwnerProfile(p.getPlayerProfile());
                        if(p.isOnline()){
                            skullMeta.setLore(new ArrayList<>(Arrays.asList("§7名稱: " + p.getName(), "§7等級: " + "§b" +p.getPlayer().getLevel()," ","§7目前狀態: " + "§a在線" )));
                        }else {
                            long lastlogin = p.getLastPlayed() / 1000;

                            long year = ((lastlogin / 31556926)) + 1970;
                            long month = ((lastlogin / 2629743)) - (((lastlogin / 31556926)) * 12) + 1;

                            long day = ((now / 86400)) - ((lastlogin / 86400));
                            long hour = ((now / 3600)) - ((lastlogin / 3600));
                            long min = ((now / 60)) - ((lastlogin / 60));
                            long second = (now) - (lastlogin);

                            long today = (now / 86400 - (((lastlogin / 31556926) * 360) + 360)) - 1;

                            String time = null;

                            if(second < 60){
                                time = second + "秒前";
                            }else if(min < 60){
                                time = min + "分鐘前";
                            }else if (hour < 24) {
                                time = hour + "小時前";
                            }else if (day <= 3){
                                time = day + "天前";
                            }else if((((now / 31556926) + 1970) - year) < 1){
                                long days = today - day;
                                time =  month + "/" + days;
                            }else{
                                long days = today - day;
                                time = year + "/" + month + "/" + days;
                            }
                            skullMeta.setLore(new ArrayList<>(Arrays.asList("§7名稱: " + p.getName(), "§7上次遊玩時間: " + time, " ", "§7目前狀態: " + "§4離線")));
                        }
                        skull.setItemMeta(skullMeta);
                        for(int i = 9; i<18; i+=2){
                            ItemStack placeholder = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
                            ItemMeta placeholderMeta = placeholder.getItemMeta();
                            placeholderMeta.setDisplayName("§b(ゝ∀･)");
                            placeholder.setItemMeta(placeholderMeta);
                            GUI.setItem(i, placeholder);
                        }
                        for(int i = 10; i<17;i+=2){
                            ItemStack placeholder = new ItemStack(Material.WHITE_STAINED_GLASS_PANE, 1);
                            ItemMeta placeholderMeta = placeholder.getItemMeta();
                            placeholderMeta.setDisplayName("§bd(`･∀･)b");
                            placeholder.setItemMeta(placeholderMeta);
                            GUI.setItem(i, placeholder);
                        }
                        ItemStack uuid = new ItemStack(Material.PAPER, 1);
                        ItemMeta uuidMeta = uuid.getItemMeta();
                        uuidMeta.setDisplayName("§6UUID");
                        uuidMeta.setLore(new ArrayList<>(Arrays.asList("§7" + p.getUniqueId())));
                        uuid.setItemMeta(uuidMeta);

                        GUI.setItem(19,uuid);
                        GUI.setItem(4, skull);

                        ((Player) sender).openInventory(GUI);
                        return true;
                    }else{
                        sender.sendMessage("/online open <Player>");
                        return true;
                    }
                }
                if(args[0].equals("test")){
                    UUID bffUuid = getServer().getOfflinePlayer(args[1]).getUniqueId();

                    OfflinePlayer p = Bukkit.getOfflinePlayer(bffUuid);

                    sender.sendMessage("" + p.getUniqueId());

                    return true;
                }
            }
        }else{
            sender.sendMessage("此指令只能由玩家執行");
        }
        return false;
    }
}
