package com.starwindtw.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class WebCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (args.length == 0) {
            sender.sendMessage("https://forum.gamer.com.tw/Co.php?bsn=18673&sn=876113");
            return true;
        }else{
            return false;
        }
    }
}

