package test.java.utils;

import java.util.ResourceBundle;

public class PropertyLoader {
    private static ResourceBundle resBundle = ResourceBundle.getBundle("config");

    public static String loadProperty(String source) {
        return resBundle.getString(source);
    }
}