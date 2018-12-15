package ua.com.finalProject.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class MessageManager {
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
    private MessageManager() { }
    public static String getProperty(String key) {
        return property.getProperty(key);
    }
}