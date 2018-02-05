package me.thestralmoon.icehorse.utils;

import me.thestralmoon.icehorse.Main;
import org.bukkit.ChatColor;

public class ChatUtils {

    private static String[] colors = new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e"};

    public ChatUtils() {
    }

    public static String format(String arg0) {
        return ChatColor.translateAlternateColorCodes('&', arg0);
    }

    public static String randomColor(String arg0) {
        return ChatColor.translateAlternateColorCodes('&', "&" +
                colors[Main.random().nextInt(colors.length)] + arg0);
    }

    public static String getRandomColor() {
        return ChatColor.translateAlternateColorCodes('&', "&" + colors[Main.random().nextInt(colors.length)]);
    }

    public static String stripColor(String arg0) {
        String newString = stripColorFormat(arg0);
        return ChatColor.stripColor(newString);
    }

    public static String stripPlaceHolderColor(String placeHolder) {
        return stripColor(placeHolder);
    }

    private static String stripColorFormat(String string) {
        string = string.replace("&0", "");
        string = string.replace("&1", "");
        string = string.replace("&2", "");
        string = string.replace("&3", "");
        string = string.replace("&4", "");
        string = string.replace("&5", "");
        string = string.replace("&6", "");
        string = string.replace("&7", "");
        string = string.replace("&8", "");
        string = string.replace("&9", "");
        string = string.replace("&a", "");
        string = string.replace("&b", "");
        string = string.replace("&c", "");
        string = string.replace("&d", "");
        string = string.replace("&e", "");
        string = string.replace("&f", "");
        string = string.replace("&k", "");
        string = string.replace("&l", "");
        string = string.replace("&m", "");
        string = string.replace("&n", "");
        string = string.replace("&o", "");
        string = string.replace("&r", "");
        return string;
    }
}
