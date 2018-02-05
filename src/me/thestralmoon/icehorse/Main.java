package me.thestralmoon.icehorse;

import me.thestralmoon.icehorse.commands.GuiCmd;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class Main extends JavaPlugin {

    private static Random random = new Random();

    public void onEnable() {

        getCommand("horse").setExecutor(new GuiCmd());

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[IceHorse] has been Enabled!");
    }

    public void onDisable() {

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[IceHorse] has been Disabled!");
    }

    public static ItemStack getHead(String name) {
        HeadType headType = new HeadType();
        if (headType.getName().equals(name)) {
            return headType.getItemStack();
            }

            return null;
        }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("head")) {
            Player player = (Player) sender;
            player.getInventory().addItem(getHead(args[0]));

            return true;
        }
        return false;
    }

    public static Random random() {
        return random;
    }
}
