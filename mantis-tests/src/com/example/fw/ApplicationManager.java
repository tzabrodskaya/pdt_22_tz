package com.example.fw;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
/**
 * Manager class for manipulation with test application
 * 
 * @version 0.1
 *
 */
public class ApplicationManager {
	
	private static ApplicationManager singleton = new ApplicationManager();
	
	private DriverHelper driverHelper;
	private HibernateHelper hibernateHelper;
	private NavigationHelper navigationHelper;
	private AccountHelper accountHelper;
	private MailHelper mailHelper;
	private JamesHelper jamesHelper;
	
	public WebDriver appDriver;	
	private Properties props;

	
	
	private ApplicationManager() {
	}
    
	public static ApplicationManager getInstance() {
		return singleton;
	}
	
	public void setProperties(Properties props) {
		this.props = props;
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

	public AccountHelper getAccountHelper() {
		if(accountHelper == null) {
			accountHelper = new AccountHelper(this);
		}
		return accountHelper;
	}

	public NavigationHelper navigateTo() {
		if(navigationHelper == null) {
			navigationHelper = new NavigationHelper(this);
		}
		return navigationHelper;
	}

	public MailHelper getMailHelper() {
		if(mailHelper == null) {
			mailHelper = new MailHelper(this);
		}
		return mailHelper;
	}

	public JamesHelper getJamesHelper() {
		if(jamesHelper == null) {
			jamesHelper = new JamesHelper(this);
		}
		return jamesHelper;
	}
}
