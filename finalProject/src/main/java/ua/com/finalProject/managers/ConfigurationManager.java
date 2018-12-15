package ua.com.finalProject.managers;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConfigurationManager {

    private static Properties property = new Properties();
    static {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:\\Users\\totito\\IdeaProjects\\finalProject\\src\\main\\java\\resources\\config.properties");
            property.load(fis);

        }catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
    // класс извлекает информацию из файла config.properties
    private ConfigurationManager() {
    }
    public static String getProperty(String key) {
        return property.getProperty(key);
    }
}
