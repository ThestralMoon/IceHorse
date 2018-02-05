package me.thestralmoon.icehorse.utils;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InventoryUtils {

    public InventoryUtils() {
    }

    public static ItemStack inventory(Inventory inventory, ItemStack itemStack, int slot) {
        inventory.setItem(slot, itemStack);
        return itemStack;
    }

    public static ItemStack inventory(Inventory inventory, ItemStack itemStack, String placeHolder, String replace, int slot) {
        ItemStack item = itemStack.clone();
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta.getLore() != null) {
            ArrayList<String> itemLore = new ArrayList();
            Iterator iterator = itemMeta.getLore().iterator();

            while (iterator.hasNext()) {
                String s1 = (String) iterator.next();
                itemLore.add(ChatUtils.format(s1.replace(placeHolder, replace)));
            }

            itemMeta.setLore(itemLore);
        }

        item.setItemMeta(itemMeta);
        inventory.setItem(slot, item);
        return item;
    }

    public static ItemStack inventory(Inventory inventory, ItemStack itemStack, List<String> placeHolder, List<String> replace, int slot) {
        ItemStack item = itemStack.clone();
        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta.getLore() != null) {
            ArrayList<String> itemLore = new ArrayList();
            Iterator var9 = itemMeta.getLore().iterator();

            while (true) {
                while (var9.hasNext()) {
                    String s1 = (String) var9.next();
                    if (placeHolder.size() == replace.size()) {
                        String lore = s1;

                        for (int i = 0; i < placeHolder.size(); ++i) {
                            lore = ChatUtils.format(lore.replace((CharSequence) placeHolder.get(i), (CharSequence) replace.get(i)));
                        }

                        itemLore.add(lore);
                    } else {
                        itemLore.add(ChatUtils.format(s1));
                    }
                }

                itemMeta.setLore(itemLore);
                break;
            }
        }

        addItemFlags(itemMeta);
        item.setItemMeta(itemMeta);
        inventory.setItem(slot, item);
        return item;
    }

    public static void addItemFlags(ItemMeta itemMeta) {
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES});
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_DESTROYS});
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS});
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_PLACED_ON});
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_POTION_EFFECTS});
        itemMeta.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_UNBREAKABLE});

    }
}
