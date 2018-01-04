package me.thestralmoon.icehorse;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public Inventory horseGui = Bukkit.createInventory(null, 27, ChatColor.GOLD + "Horse Selection GUI");

    public void onEnable() {

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[IceHorse] has been Enabled!");
    }

    public void onDisable() {

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[IceHorse] has been Disabled!");
    }
}
