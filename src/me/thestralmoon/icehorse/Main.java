package me.thestralmoon.icehorse;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.UUID;

public class Main extends JavaPlugin {

    public void onEnable() {

        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[IceHorse] has been Enabled!");
    }

    public void onDisable() {

        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[IceHorse] has been Disabled!");
    }

    public static ItemStack getHead(String name) {
        for (Heads heads : Heads.values()) {
            if (heads.getName().equals(name)) {

                return heads.getItemStack();
            }
        }

        return null;
    }

    public static ItemStack createSkull(String url, String name) {

        ItemStack customHead = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        if (url.isEmpty())
            return customHead;

        SkullMeta skullMeta = (SkullMeta) customHead.getItemMeta();
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        profile.getProperties().put("textures", new Property("textures", url));

        try {

            Field profileField = skullMeta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(skullMeta, profile);

        } catch (IllegalArgumentException|NoSuchFieldException|SecurityException|IllegalAccessException error) {
            error.printStackTrace();
        }

        customHead.setItemMeta(skullMeta);
        return customHead;
    }
}
