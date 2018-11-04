package ua.com.project1.demo;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResourceManager {
	INSTANCE;
	
	private ResourceBundle rb;
	private final String resourceName;
	
	private ResourceManager() {
		resourceName =  "ua.com.vehicles.config.text";
		rb = ResourceBundle.getBundle(resourceName, Locale.getDefault());
	}
	
	public void changeResource(Locale locale) {
		rb = ResourceBundle.getBundle(resourceName, locale);
	}
	
	public String getString(String key) {
		return rb.getString(key);
	}
}
