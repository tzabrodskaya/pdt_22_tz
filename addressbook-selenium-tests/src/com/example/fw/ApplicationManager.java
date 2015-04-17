package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
/**
 * Manager class for manipulation with test application
 * @version 0.3
 *
 */
public class ApplicationManager {
	
	private static ApplicationManager singleton = new ApplicationManager();
	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private DriverHelper driverHelper;
	
	public WebDriver appDriver;
	public String baseUrl = "http://localhost/";
	
	private Properties props;
	private HibernateHelper hibernateHelper;
	
	private ApplicationManager() {
	}
    
	public static ApplicationManager getInstance() {
		return singleton;
	}
	
	public void setProperties(Properties props) {
		this.props = props;
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

	public DriverHelper getDriverHelper() {
		if(driverHelper == null) {
			driverHelper = new DriverHelper(this, getProperty("browser"));
		}
		return driverHelper;
	}

	public HibernateHelper getHibernateHelper() {
		if(hibernateHelper == null) {
			hibernateHelper = new HibernateHelper(this);
		}
		return hibernateHelper;
		
	}

}
