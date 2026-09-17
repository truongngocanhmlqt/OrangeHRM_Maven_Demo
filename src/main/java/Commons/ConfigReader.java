package Commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    private static final Properties properties = new Properties();

    static {
        loadPropertiesFile("config.properties", true);
        loadPropertiesFile("config.local.properties", false);
    }

    private static void loadPropertiesFile(String fileName, boolean required) {
        try (InputStream inputStream = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
            if (inputStream == null) {
                if (required) {
                    throw new RuntimeException(fileName + " not found in classpath");
                }
                return;
            }
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("Could not load " + fileName, e);
        }
    }

    public static String getProperty(String key) {
        return getProperty(key, "");
    }

    public static String getProperty(String key, String defaultValue) {
        String systemValue = System.getProperty(key);
        if (systemValue != null && !systemValue.trim().isEmpty()) {
            return systemValue.trim();
        }

        String envValue = System.getenv(toEnvironmentKey(key));
        if (envValue != null && !envValue.trim().isEmpty()) {
            return envValue.trim();
        }

        return properties.getProperty(key, defaultValue).trim();
    }

    private static String toEnvironmentKey(String key) {
        return key.replace('.', '_').replace('-', '_').toUpperCase();
    }
}
