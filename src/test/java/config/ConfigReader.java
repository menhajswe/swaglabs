package config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    public static Properties getPropertyObjects() {
        Properties properties = new Properties();
        try {
            FileInputStream inputStream = new FileInputStream("src/test/resources/config.properties");
            properties.load(inputStream);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return properties;
    }

    public static String getStandardUserName() {
        return getPropertyObjects().getProperty("usernamestandard");
    }

    public static String getPassword() {
        return getPropertyObjects().getProperty("password");
    }
}
