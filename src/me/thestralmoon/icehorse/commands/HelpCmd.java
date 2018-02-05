package me.thestralmoon.icehorse.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class HelpCmd implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("horsehelp")) {
            sender.sendMessage(ChatColor.GREEN + "-------" + ChatColor.GOLD + "Horse Selection GUI" + ChatColor.GREEN + "-------");
            sender.sendMessage(ChatColor.GREEN + "                                                                              ");
            sender.sendMessage(ChatColor.WHITE + "/head (horsetype) - To Get A Horse Head");
            sender.sendMessage(ChatColor.WHITE + "Black Horse - blackhorse");
            sender.sendMessage(ChatColor.WHITE + "Brown Horse - brownhorse");
            sender.sendMessage(ChatColor.WHITE + "Chestnut Horse - chestnuthorse");
            sender.sendMessage(ChatColor.WHITE + "Creamy Horse - creamyhorse");
            sender.sendMessage(ChatColor.WHITE + "Dark Brown Horse - darkbrownhorse");
            sender.sendMessage(ChatColor.WHITE + "Gray Horse - grayhorse");
            sender.sendMessage(ChatColor.WHITE + "White Horse - whitehorse");
            sender.sendMessage(ChatColor.WHITE + "Skeleton Horse - skeletonhorse");
            sender.sendMessage(ChatColor.WHITE + "Zombie Horse - zombiehorse");
            sender.sendMessage(ChatColor.GREEN + "                                                                              ");
            sender.sendMessage(ChatColor.GREEN + "-------" + ChatColor.GOLD + "By ThestralMoon" + ChatColor.GREEN + "-------");
        }
        return true;
    }
}