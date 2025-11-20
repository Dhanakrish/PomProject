package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static void initProperties() {
        try {
            FileInputStream ip = new FileInputStream("config/config.properties");
            prop = new Properties();
            prop.load(ip);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        return prop.getProperty(key);
    }
}
