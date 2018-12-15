package ua.com.finalProject.resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class ConfigurationManager {
    //!!!!!!!!!
    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("config");
    // класс извлекает информацию из файла config.properties
    private ConfigurationManager() { }
    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
