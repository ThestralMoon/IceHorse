package me.thestralmoon.icehorse.utils;

import org.bukkit.Bukkit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VersionManager {

    public VersionManager() {
        if (getBukkitVersion() != null) {
            ServerVersion.setServerVersion(ServerVersion.valueOf(getBukkitVersion()));
        } else {
            ServerVersion.setServerVersion(ServerVersion.valueOfSpigotRelease(getMinecraftVersion()));
        }

    }

    public static boolean is1_8OrAbove() {
        return is1_8Version() || is1_9Version() || is1_10Version() || is1_11Version() || is1_12Version();
    }

    public static boolean is1_9OrAbove() {
        return is1_9Version() || is1_10Version() || is1_11Version() || is1_12Version();
    }

    public static boolean is1_10OrAbove() {
        return is1_10Version() || is1_11Version() || is1_12Version();
    }

    public static boolean is1_11OrAbove() {
        return is1_11Version() || is1_12Version();
    }

    public static boolean is1_12OrAbove() {
        return is1_12Version();
    }

    public static boolean is1_8Version() {
        return is1_8_R1Version() || is1_8_R2Version() || is1_8_R3Version();
    }

    public static boolean is1_9Version() {
        return is1_9_R1Version() || is1_9_R2Version();
    }

    public static boolean is1_10Version() {
        return is1_10_R1Version();
    }

    public static boolean is1_11Version() {
        return is1_11_R1Version();
    }

    public static boolean is1_12Version() {
        return is1_12_R1Version();
    }

    public static boolean is1_8_R1Version() {
        return ServerVersion.getServerVersion() == ServerVersion.v1_8_R1;
    }

    public static boolean is1_8_R2Version() {
        return ServerVersion.getServerVersion() == ServerVersion.v1_8_R2;
    }

    public static boolean is1_8_R3Version() {
        return ServerVersion.getServerVersion() == ServerVersion.v1_8_R3;
    }

    public static boolean is1_9_R1Version() {
        return ServerVersion.getServerVersion() == ServerVersion.v1_9_R1;
    }

    public static boolean is1_9_R2Version() {
        return ServerVersion.getServerVersion() == ServerVersion.v1_9_R2;
    }

    public static boolean is1_10_R1Version() {
        return ServerVersion.getServerVersion() == ServerVersion.v1_10_R1;
    }

    public static boolean is1_11_R1Version() {
        return ServerVersion.getServerVersion() == ServerVersion.v1_11_R1;
    }

    public static boolean is1_12_R1Version() {
        return ServerVersion.getServerVersion() == ServerVersion.v1_12_R1;
    }

    public static String getBukkitVersion() {
        Matcher matcher = Pattern.compile("v\\d+_\\d+_R\\d+").matcher(Bukkit.getServer().getClass().getPackage().getName());
        return matcher.find() ? matcher.group() : null;
    }

    public static String getMinecraftVersion() {
        Matcher matcher = Pattern.compile("(\\(MC: )([\\d\\.]+)(\\))").matcher(Bukkit.getVersion());
        return matcher.find() ? matcher.group(2) : null;
    }

    private static int compare(String reference, String comparison) throws NumberFormatException {
        String[] referenceSplit = reference.split("\\.");
        String[] comparisonSplit = comparison.split("\\.");
        int longest = Math.max(referenceSplit.length, comparisonSplit.length);
        int[] referenceNumbersArray = new int[longest];
        int[] comparisonNumbersArray = new int[longest];

        int i;
        for(i = 0; i < referenceSplit.length; ++i) {
            referenceNumbersArray[i] = Integer.parseInt(referenceSplit[i]);
        }

        for(i = 0; i < comparisonSplit.length; ++i) {
            comparisonNumbersArray[i] = Integer.parseInt(comparisonSplit[i]);
        }

        for(i = 0; i < longest; ++i) {
            int diff = referenceNumbersArray[i] - comparisonNumbersArray[i];
            if (diff > 0) {
                return 1;
            }

            if (diff < 0) {
                return -1;
            }
        }

        return 0;
    }

    public static boolean isVersionGreaterEqual(String reference, String thanWhat) {
        return compare(reference, thanWhat) >= 0;
    }

    public static boolean isVersionLessEqual(String reference, String thanWhat) {
        return compare(reference, thanWhat) <= 0;
    }

    public static boolean isVersionBetweenEqual(String reference, String lowest, String highest) {
        return isVersionGreaterEqual(reference, lowest) && isVersionLessEqual(reference, highest);
    }

    public static boolean isClassExists(String className) {
        try {
            Class.forName(className);
            return true;
        } catch (Throwable var2) {
            return false;
        }
    }
}