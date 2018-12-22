package ua.com.finalProject.managers;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DBManager {
    private static final Logger log = Logger.getLogger(DBManager.class);

    private static Properties property = new Properties();

    static {
        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("db_connection.properties");
            property.load(input);

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    // класс извлекает информацию из файла config.properties
    private DBManager() {
    }

    public static String getProperty(String key) {
        return property.getProperty(key);
    }
}
