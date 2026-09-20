package Commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Reads key-value configuration from properties files.
 *
 * Load order (later file overrides earlier one for the same key):
 *   1. config.properties        - committed defaults, safe to share
 *   2. config.local.properties  - optional, personal/local overrides, not committed to git
 */
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
        return properties.getProperty(key, defaultValue).trim();
    }
}
