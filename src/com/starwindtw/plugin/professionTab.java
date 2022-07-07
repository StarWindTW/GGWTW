package com.starwindtw.plugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class professionTab implements TabCompleter {
    List<String> arguments = new ArrayList<String>();
    List<String> args1 = new ArrayList<String>();

    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args){
        if(args1.isEmpty()){
            args1.add("menu");
            args1.add("set");
            args1.add("confirm");
            args1.add("help");
        }
        if(arguments.isEmpty()){
            arguments.add("Thieves");
            arguments.add("Wizard");
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
        if (args[0].equals("confirm") && args.length == 2) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[1].toLowerCase()))
                    result.add(a);
            }
            return result;
        }
        if (args[0].equals("set") && args.length == 3) {
            for (String a : arguments) {
                if (a.toLowerCase().startsWith(args[2].toLowerCase()))
                    result.add(a);
            }
            return result;
        }
        return null;
    }
}
