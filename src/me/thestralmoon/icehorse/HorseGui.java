package me.thestralmoon.icehorse;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;

public class HorseGui implements Listener {

    private Main plugin = Main.getPlugin(Main.class);

    public void horseSelectionGui(Player player) {

        Inventory horseGui = plugin.getServer().createInventory(null, 27, ChatColor.GOLD + "Horse Selection GUI");
        player.openInventory(horseGui);
    }
}