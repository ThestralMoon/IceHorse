package me.thestralmoon.icehorse.utils;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.bukkit.Material;
import org.bukkit.SkullType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.apache.commons.codec.binary.Base64;

import java.lang.reflect.Field;
import java.util.*;

public class SkullUtils {

    public static ItemStack createSkull(String displayName, List<String> lore, String url) {
        if (!(url.startsWith("http://textures.minecraft.net/texture/"))) {
            url = "http://textures.minecraft.net/texture/" + url;
        }

        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short) SkullType.PLAYER.ordinal());
        SkullMeta skullMeta = (SkullMeta) head.getItemMeta();
        skullMeta.setDisplayName(ChatUtils.format(displayName));
        ArrayList<String> itemLore = new ArrayList();
        if (lore != null) {
            Iterator var7 = lore.iterator();

            while (var7.hasNext()) {
                String sl = (String) var7.next();
                itemLore.add(ChatUtils.format(sl));
            }

            skullMeta.setLore(itemLore);
        }

        if (url.isEmpty()) {
            return head;
        } else {

            GameProfile profile = new GameProfile(UUID.randomUUID(), (String) null);
            byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
            profile.getProperties().put("textures", new Property("textures", new String(encodedData)));

            try {

                Field profileField = skullMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(skullMeta, profile);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException exception) {
                exception.printStackTrace();
            }

            InventoryUtils.addItemFlags(skullMeta);
            head.setItemMeta(skullMeta);
            return head;
        }
    }

    public static ItemStack createSkull(String displayName, List<String> lore, String url, String localizedName) {
        if (!(url.startsWith("http://textures.minecraft.net/texture/"))) {
            url = "http://textures.minecraft.net/texture/" + url;
        }

        ItemStack head = new ItemStack(Material.SKULL_ITEM, 1, (short)SkullType.PLAYER.ordinal());
        SkullMeta skullMeta = (SkullMeta)head.getItemMeta();
        skullMeta.setDisplayName(ChatUtils.format(displayName));
        if (VersionManager.is1_12OrAbove()) {
            skullMeta.setLocalizedName(localizedName);
        }

        ArrayList<String> itemLore = new ArrayList<>();
        if (lore != null) {
            Iterator iterator = lore.iterator();

            while (iterator.hasNext()) {
                String sl = (String) iterator.next();
                itemLore.add(ChatUtils.format(sl));
            }

            skullMeta.setLore(itemLore);
        }

        if (url.isEmpty()) {
            return head;
        } else {
            GameProfile profile = new GameProfile(UUID.randomUUID(), (String) null);
            byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
            profile.getProperties().put("textures", new Property("textures", new String(encodedData)));

            try {

                Field profileField = skullMeta.getClass().getDeclaredField("profile");
                profileField.setAccessible(true);
                profileField.set(skullMeta, profile);
            } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException exception) {
                exception.printStackTrace();
            }

            InventoryUtils.addItemFlags(skullMeta);
            head.setItemMeta(skullMeta);
            return head;
        }
    }

    public static boolean getCurrentItem(InventoryClickEvent event, String displayName, int slot) {
        return event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatUtils.format(displayName)) && event.getSlot() == slot;
    }

    public static boolean getCurrentItem(InventoryClickEvent event, String displayName, ItemStack itemStack, int slot) {
        if (VersionManager.is1_8Version() && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatUtils.format(displayName)) && event.getCurrentItem().getTypeId() == itemStack.getTypeId() && event.getCurrentItem().getDurability() == itemStack.getDurability() && event.getSlot() == slot) {
            return true;
        } else {
            return event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatUtils.format(displayName)) && event.getCurrentItem().equals(itemStack) && event.getSlot() == slot;
        }
    }

    public static boolean getCurrentItem(InventoryClickEvent event, String displayName, int typeId, int data, int slot) {
        return event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatUtils.format(displayName)) && event.getCurrentItem().getTypeId() == typeId && event.getCurrentItem().getDurability() == data && event.getSlot() == slot;
    }

    public static boolean getCurrentItem(InventoryClickEvent event, String displayName, int typeId, int data) {
        return event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatUtils.format(displayName)) && event.getCurrentItem().getTypeId() == typeId && event.getCurrentItem().getDurability() == data;
    }
}