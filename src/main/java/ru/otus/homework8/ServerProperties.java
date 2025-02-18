package ru.otus.homework8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServerProperties {
    private static Properties properties;

    public ServerProperties() throws IOException {
        try (InputStream input = new FileInputStream("server.properties")) {
            properties = new Properties();
            properties.load(input);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
