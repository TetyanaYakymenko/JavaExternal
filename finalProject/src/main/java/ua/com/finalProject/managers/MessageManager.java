package ua.com.finalProject.managers;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class MessageManager {

    private static final Logger log = Logger.getLogger(MessageManager.class);

    private static Properties property = new Properties();

    static {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("messages.properties");
            property.load(input);

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private MessageManager() {
    }

    public static String getProperty(String key) {
        return property.getProperty(key);
    }
}