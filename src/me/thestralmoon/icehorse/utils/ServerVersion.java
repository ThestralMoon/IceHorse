package me.thestralmoon.icehorse.utils;

public enum ServerVersion {

    v1_8_R1("1.8", "1.8-R1", new String[]{"1.8"}),
    v1_8_R2("1.8", "1.8-R2", new String[]{"1.8.3"}),
    v1_8_R3("1.8", "1.8-R3", new String[]{"1.8.4", "1.8.5", "1.8.6", "1.8.7", "1.8.8"}),
    v1_9_R1("1.9", "1.9-R1", new String[]{"1.9", "1.9.2"}),
    v1_9_R2("1.9", "1.9-R2", new String[]{"1.9.4"}),
    v1_10_R1("1.10", "1.10-R1", new String[]{"1.10", "1.10.2"}),
    v1_11_R1("1.11", "1.11-R1", new String[]{"1.11", "1.11.1", "1.11.2"}),
    v1_12_R1("1.12", "1.12-R1", new String[]{"1.12", "1.12.1", "1.12.2"});

    private String name;
    private String detailName;
    private String[] spigotReleases;
    private static ServerVersion serverVersion = null;

     ServerVersion(String name, String detailName, String[] spigotReleases) {
        this.name = name;
        this.detailName = detailName;
        this.spigotReleases = spigotReleases;
    }

    public String getName() {
        return this.name;
    }

    public String getDetailName() {
        return this.detailName;
    }

    public String[] getSpigotReleases() {
        return this.spigotReleases;
    }

    public static ServerVersion getServerVersion() {
        return serverVersion;
    }

    public static void setServerVersion(ServerVersion arg0) {
        serverVersion = arg0;
    }

    public static ServerVersion valueOfSpigotRelease(String arg0) {
        ServerVersion[] var4;
        int var3 = (var4 = values()).length;

        for(int var2 = 0; var2 < var3; ++var2) {
            ServerVersion version = var4[var2];
            String[] var8;
            int var7 = (var8 = version.getSpigotReleases()).length;

            for(int var6 = 0; var6 < var7; ++var6) {
                String release = var8[var6];
                if (release.equalsIgnoreCase(arg0)) {
                    return version;
                }
            }
        }

        return null;
    }
}
