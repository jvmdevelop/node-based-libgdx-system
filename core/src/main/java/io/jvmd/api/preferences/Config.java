package io.jvmd.api.preferences;

public class Config {

    private final static String homePath = System.getProperty("user.home");
    private final static String prefix = homePath +".bpb";

    public static String getPrefix() {
        return prefix;
    }


}
