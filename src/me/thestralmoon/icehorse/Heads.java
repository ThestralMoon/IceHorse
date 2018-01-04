package me.thestralmoon.icehorse;

import org.bukkit.inventory.ItemStack;

public enum Heads {

    BLACK_HORSE("NjRiN2ZjNWY3YTlkZGZkZDFhYTc5MzE3NDEwZmMxOTI5ZjkxYmRkZjk4NTg1OTM4YTJhNTYxOTlhNjMzY2MifX19", "blackhorse"),
    BROWN_HORSE("YmVkZjczZWExMmNlNmJkOTBhNGFlOWE4ZDE1MDk2NzQ5Y2ZlOTE4MjMwZGM4MjliMjU4MWQyMjNiMWEyYTgifX19", "brownhorse"),
    CHESTNUT_HORSE("", "chestnuthorse"),
    CREAMY_HORSE("", "creamyhorse"),
    DB_HORSE("", "darkbrownhorse"),
    GRAY_HORSE("", "grayhorse"),
    WHITE_HORSE("", "whitehorse"),
    SKELETON_HORSE("", "skeletonhorse"),
    ZOMBIE_HORSE("", "zombiehorse");

    private ItemStack item;

    private String idTag;

    private String prefix = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

    Heads(String texture, String id) {

        item = Main.createSkull(prefix + texture, id);
        idTag = id;
    }

    public ItemStack getItemStack() {
        return item;
    }

    public String getName() {
        return idTag;
    }
}
