package com.example.fw;

import org.openqa.selenium.WebDriver;
/**
 * Manager class for manipulation with test application
 * @author tzabrodskaya
 * @version 0.1
 *
 */
public class ApplicationManager {
	

	private NavigationHelper navigationHelper;
	private GroupHelper groupHelper;
	private ContactHelper contactHelper;
	private DriverHelper driverHelper;
	
	public WebDriver appDriver;
	public String baseUrl = "http://localhost/";
	
	
	
	public ApplicationManager() {
		driverHelper = new DriverHelper(this);
	}
	
	public ApplicationManager(String browser) {
		driverHelper = new DriverHelper(this, browser);
	}
    
	public void stop() {
		driverHelper.quit();
	}

	
	public NavigationHelper getNavigationHelper() {
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
