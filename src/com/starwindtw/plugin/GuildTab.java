package com.starwindtw.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class GuildTab implements TabCompleter {

    List<String> args1 = new ArrayList<String>();
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args){
        if(args1.isEmpty()){
            args1.add("create");
            args1.add("menu");
            args1.add("help");
        }

        List<String> result = new ArrayList<String>();

        if(args.length == 1){
            for(String b : args1){
                if(b.toLowerCase().startsWith(args[0].toLowerCase())) {
                    result.add(b);
                }
            }
            return result;
        }

        return null;
    }
}
