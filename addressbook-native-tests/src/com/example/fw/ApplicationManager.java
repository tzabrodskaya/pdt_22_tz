package com.example.fw;

import java.io.IOException;
import java.util.Properties;


/**
 * Manager class for manipulation with test application
 * 
 * @version 0.1
 *
 */
public class ApplicationManager {
	
	private static ApplicationManager singleton;
	private Properties props;
	private ContactHelper contactHelper;
	private ProcessHelper processHelper;
	private AutoItHelper autoItHelper;
		
	public static ApplicationManager getInstance(Properties properties) throws IOException {
		
		if (singleton == null) {
			singleton = new ApplicationManager();
			singleton.setProperties(properties);
			singleton.start();
		}
		return singleton;
	}
	
	public void setProperties(Properties props) {
		this.props = props;
		
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
	
	public int getIntProperty(String key) {
		return Integer.parseInt(getProperty(key));
	}
	
	public void start() throws IOException {
		getProcessHelper().startAppUnderTest();
	}
	public void stop() {
		getProcessHelper().stopAppUnderTest();
		
	}

	public ContactHelper getContactHelper() {
		if (contactHelper == null) {
			contactHelper = new ContactHelper(this);
		}
		return contactHelper;
	}
	
	public ProcessHelper getProcessHelper() {
		if (processHelper == null) {
			processHelper = new ProcessHelper(this);
		}
		return processHelper;
	}
	
	public AutoItHelper getAutoItHelper() {
		if (autoItHelper == null) {
			autoItHelper = new AutoItHelper(this);
		}
		return autoItHelper;
	}




	
	
	
}
