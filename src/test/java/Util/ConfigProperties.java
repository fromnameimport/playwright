package Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {
    public static Properties properties;
    private static String configPath = "src/test/resources/configuration.properties";

    public static void initializePropertyFile() {
        properties = new Properties();
        try {
            InputStream inputStream = new FileInputStream(configPath);
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
