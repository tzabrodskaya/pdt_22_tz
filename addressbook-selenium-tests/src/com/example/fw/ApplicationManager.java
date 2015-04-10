package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
/**
 * Manager class for manipulation with test application
 * @version 0.2
 *
 */
public class ApplicationManager {
	
	private static ApplicationManager singleton;
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private DriverHelper driverHelper;
	
	public WebDriver appDriver;
	public String baseUrl = "http://localhost/";
	
	private Properties props;
	
	public ApplicationManager() {
	}
    
	public static ApplicationManager getInstance() {
		
		if (singleton == null) {
			singleton = new ApplicationManager();
		}
		return singleton;
	}
	
	public void setProperties(Properties props) {
		this.props = props;
		driverHelper = new DriverHelper(this, getProperty("browser"));
		baseUrl = getProperty("baseUrl");
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
	
	public Long getLongProperty(String key) {
		return Long.parseLong(getProperty(key));
	}
	
	
	public void stop() {
		driverHelper.quit();
	}

	
	public NavigationHelper navigateTo() {
		if(navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}
	
	public GroupHelper getGroupHelper() {
		if(groupHelper == null) {
			groupHelper = new GroupHelper(this);
		}
		return groupHelper;
	}
	
	public ContactHelper getContactHelper() {
		if(contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
	
}
