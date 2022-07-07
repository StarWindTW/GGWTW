package com.starwindtw.plugin;

import java.io.File;

public class ConfigManger {
    public static boolean hasBank(String uuid) {
        File f = new File("plugins/profile" + uuid + ".yml");

        return f.exists();
    }
}
