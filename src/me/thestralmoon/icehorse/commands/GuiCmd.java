package me.thestralmoon.icehorse.commands;

import me.thestralmoon.icehorse.HorseGui;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GuiCmd implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You Must Be A Player To Use This Command!");
            return true;
        }

        if (cmd.getName().equalsIgnoreCase("horse")) {
            Player player = (Player) sender;
            HorseGui horseGui = new HorseGui();

            horseGui.horseSelectionGui(player);

            return true;
        }
        return false;
    }
}
