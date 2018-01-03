package me.thestralmoon.icehorse;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[IceHorse] has been Enabled!");
    }

    public void onDisable() {

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[IceHorse] has been Disabled!");
    }
}
