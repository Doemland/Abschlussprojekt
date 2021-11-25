package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnviromentConfig {

    private static final String PROFILE = "profile";
    private static final String DEFAULT_PROPERTIES_FILE = "application.properties";
    private static final String PROFILE_RELATED_PROPERTIES_FILE = "application-%s.properties";
    private static final String PROFILE_RELATED_PROPERTIES_FILE_PATH = "src/main/resources/application.properties".concat(PROFILE_RELATED_PROPERTIES_FILE);
    private static final String DEFAULT_PROPERTIES_FILE_PATH = "src/main/resources/".concat(DEFAULT_PROPERTIES_FILE);

    static {
        loadEnvironmentProperties();
    }

    public static String getProperty(String property) {
        return System.getProperty(property);
    }

    private static void loadEnvironmentProperties() {
        final String profile = System.getProperty(PROFILE);
        final String path;

        // Konfigurationsdatei anahand von dem Profil auswählen
        if (profile == null || !profile.equals("test")) {
            path = DEFAULT_PROPERTIES_FILE_PATH;
        } else {
            path = String.format(PROFILE_RELATED_PROPERTIES_FILE_PATH, profile);
        }

        // die Konfigurationsdatei laden
        try (InputStream is = new FileInputStream(path)) {
            final Properties properties = new Properties();
            properties.load(is);
            System.getProperties().putAll(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
