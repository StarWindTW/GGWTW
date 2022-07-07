package com.starwindtw.plugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;

public class ScoreBoardListener implements Listener {
    private int taskID;
    @EventHandler
    public void quitServer(PlayerQuitEvent e){
        LobbyBoard border = new LobbyBoard(e.getPlayer().getUniqueId());
        if (border.hasID())
            border.stop();
    }
    @EventHandler
    public void joinServer(PlayerJoinEvent e) {
        CreateBoard(e.getPlayer());
        Start(e.getPlayer());
    }
    public void Start(Player player){
        taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), new Runnable() {
            int count = 0;
            LobbyBoard border = new LobbyBoard(player.getUniqueId());
            @Override
            public void run() {
                if (!border.hasID())
                    border.setID(taskID);
                if (count == 60)
                    count = 0;
                switch (count){
                    case 0:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&lGGWTW"));
                        break;
                    case 1:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&',"&e&lG&6&lGWTW"));
                        break;
                    case 2:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&',"&f&lG&e&lG&6&lWTW"));
                        break;
                    case 3:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&lG&f&lG&e&lW&6&lTW"));
                        break;
                    case 4:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&lGG&f&lW&e&lT&6&lW"));
                        break;
                    case 5:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&lGGW&f&lT&e&lW"));
                        break;
                    case 6:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&lGGWT&f&lW"));
                        break;
                    case 7:
                        player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(ChatColor.translateAlternateColorCodes('&',"&6&lGGWTW"));
                        CreateBoard(player);
                        break;
                }
                count++;
                if (count > 7 && count%2 == 1)
                    CreateBoard(player);
            }
        },0,2);
    }
    public void CreateBoard(Player player){

        String progress = null;
        if (player.getExp() >= 1) {
            progress = "§b■■■■■■■■■■";
        } else if (player.getExp() >= 0.9) {
            progress = "§b■■■■■■■■■§7■";
        } else if (player.getExp() >= 0.8) {
            progress = "§b■■■■■■■■§7■■";
        } else if (player.getExp() >= 0.7) {
            progress = "§b■■■■■■■§7■■■";
        } else if (player.getExp() >= 0.6) {
            progress = "§b■■■■■■§7■■■■";
        } else if (player.getExp() >= 0.5) {
            progress = "§b■■■■■§7■■■■■";
        } else if (player.getExp() >= 0.4) {
            progress = "§b■■■■§7■■■■■■";
        } else if (player.getExp() >= 0.3) {
            progress = "§b■■■§7■■■■■■■";
        } else if (player.getExp() >= 0.2) {
            progress = "§b■■§7■■■■■■■■";
        } else if (player.getExp() >= 0.1) {
            progress = "§b■§7■■■■■■■■■";
        } else {
            progress = "§7■■■■■■■■■■";
        }

        float exp = player.getExp();
        double scale = Math.pow(10, 2);
        double value = Math.floor(exp * scale) / scale * 100;
        int Intvalue = (int) value;

        double health = player.getHealth() / player.getHealthScale();
        double healthvalue = Math.floor(health * scale) / scale * 100;
        int healthInt = (int) healthvalue;
        String healthcolor = null;
        if(healthInt == 100){
            healthcolor = "§f";
        }else if (healthInt <= 30) {
            healthcolor = "§c";
        }else{
            healthcolor = "§a";
        }

        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = manager.getNewScoreboard();

        Objective objective = scoreboard.registerNewObjective("Scoreboard", "dummy", ChatColor.translateAlternateColorCodes('&',"&6&lGGWTW"));
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        Score s9 = objective.getScore("   ");
        //血量低於30%變紅100%變白其餘顯示綠
        Score s8 = objective.getScore("血量: " + healthcolor + (int) player.getHealth() + ChatColor.WHITE + "/" + (int) player.getHealthScale());
        Score s7 = objective.getScore("  ");
        Score s6 = objective.getScore(ChatColor.WHITE + "等級: " + ChatColor.AQUA + player.getLevel());
        Score s5 = objective.getScore(ChatColor.WHITE + "升級進度: " + ChatColor.AQUA + Intvalue + ChatColor.GRAY + "/§f100%");
        Score s4 = objective.getScore("[" + ChatColor.GRAY + progress + ChatColor.WHITE + "]");
        Score s3 = objective.getScore(" ");
        Score s2 = objective.getScore(ChatColor.WHITE + "職業: ");
        Score s1 = objective.getScore("");
        Score s = objective.getScore(ChatColor.YELLOW + "www.ggwtw.com");

        s9.setScore(10);
        s8.setScore(9);
        s7.setScore(8);
        s6.setScore(7);
        s5.setScore(6);
        s4.setScore(5);
        s3.setScore(4);
        s2.setScore(3);
        s1.setScore(2);
        s.setScore(1);

        player.setScoreboard(scoreboard);
    }
}
