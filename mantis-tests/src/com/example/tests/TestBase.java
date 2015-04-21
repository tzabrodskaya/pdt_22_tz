package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.ApplicationManager;
import com.example.fw.User;

/**
 * Basic methods for initialization and stop the application manager for the specified browser
 * Contain data providers
 * 
 * @version 0.1
 *
 */
public abstract class TestBase {
	
	protected static ApplicationManager app;


	@BeforeTest
	@Parameters({"configFile"})
	public void setUp(@Optional String configFile) throws Exception {
		if (configFile == null) {
			configFile = System.getProperty("configFile", "applicationFF.properties");
		}
	
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = ApplicationManager.getInstance();
		app.setProperties(properties);
		app.getDriverHelper();
	 }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	  }
	
	@DataProvider
	public Object[][] userFromConfig() {
		return new Object[][]{new Object[]{readUser()}};
	}
	 
	public User readUser() {
		User user = new User()
				.setLogin(app.getProperty("login"))
				.setPassword(app.getProperty("password"))
				.setEmail(app.getProperty("e-mail"));
		return user;
	}

}
