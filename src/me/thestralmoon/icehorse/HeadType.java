package me.thestralmoon.icehorse;

import me.thestralmoon.icehorse.utils.SkullUtils;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class HeadType {

    public HeadType() {
    }

    private static final List<HeadType> ENABLED = new ArrayList<>();
    private static final List<HeadType> VALUES = new ArrayList<>();

    public static final HeadType BLACK_HORSE;
    public static final HeadType BROWN_HORSE;
    public static final HeadType CHESTNUT_HORSE;
    public static final HeadType CREAMY_HORSE;
    public static final HeadType DB_HORSE;
    public static final HeadType GRAY_HORSE;
    public static final HeadType WHITE_HORSE;
    public static final HeadType SKELETON_HORSE;
    public static final HeadType ZOMBIE_HORSE;

    private ItemStack item;

    private List<String> lore;

    private String name;
    private String displayName;
    private String permission;
    private String idTag;
    private String prefix = "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUv";

    static {

        BLACK_HORSE = new HeadType("Black Horse", "&fBlack Horse", "icehorse.horsegui.blackhorse", null, "NjRiN2ZjNWY3YTlkZGZkZDFhYTc5MzE3NDEwZmMxOTI5ZjkxYmRkZjk4NTg1OTM4YTJhNTYxOTlhNjMzY2MifX19", "blackhorse");
        BROWN_HORSE = new HeadType("Brown Horse","&fBrown Horse","icehorse.horsegui.brownhorse",null,"YmVkZjczZWExMmNlNmJkOTBhNGFlOWE4ZDE1MDk2NzQ5Y2ZlOTE4MjMwZGM4MjliMjU4MWQyMjNiMWEyYTgifX19", "brownhorse");
        CHESTNUT_HORSE = new HeadType( "Chestnut Horse","&fChestnut Horse","icehorse.horsegui.chestnuthorse",null,"", "chestnuthorse");
        CREAMY_HORSE = new HeadType("Creamy Horse","&fCreamy Horse","icehorse.horsegui.creamyhorse",null,"", "creamyhorse");
        DB_HORSE = new HeadType("Dark Brown Horse", "&fDark Brown Horse", "icehorse.horsegui.dbhorse", null,"", "darkbrownhorse");
        GRAY_HORSE = new HeadType("Gray Horse", "&fGray Horse", "icehorse.horsegui.grayhorse", null,"", "grayhorse");
        WHITE_HORSE = new HeadType("White Horse", "&fWhite Horse", "icehorse.horsegui.whitehorse", null,"", "whitehorse");
        SKELETON_HORSE = new HeadType("Skeleton Horse", "&fSkeleton Horse",  "icehorse.horsegui.skeletonhorse", null,"", "skeletonhorse");
        ZOMBIE_HORSE = new HeadType("Zombie Horse", "&fZombie Horse", "icehorse.horsegui.zombiehorse", null,"", "zombiehorse");

    }

    public HeadType(String name, String displayName, String permission, List<String> lore, String texture, String id) {

        this.name = name;
        this.displayName = displayName;
        this.permission = permission;
        this.lore = lore;

        item = SkullUtils.createSkull(prefix + texture, lore, id);
        idTag = id;

        if (!(VALUES.contains(this))) {
            VALUES.add(this);
        }
    }

    public ItemStack getItemStack() {
        return item;
    }

    public String getName() {
        return idTag;
    }
}
