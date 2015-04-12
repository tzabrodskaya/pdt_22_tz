package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;
import java.util.Random;
import java.util.logging.Logger;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.ApplicationManager;

/**
 * Basic methods for initialization and stop the application manager
 * 
 * @version 0.1
 *
 */
public abstract class TestBase {
	
	protected Logger log = Logger.getLogger("TEST");
	protected static ApplicationManager app;

	@BeforeTest
	@Parameters({"configFile"})
	public void setUp(@Optional String configFile) throws Exception {
		if (configFile == null) {
			configFile = System.getProperty("configFile", "application.properties");
		}
		
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		log.info("setUp start");
		app = ApplicationManager.getInstance(properties);
		log.info("setUp end");
		
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		log.info("tearDown start");
		ApplicationManager.getInstance(null).stop();
		log.info("tearDown end");
	  }
	
	public static String generateNotEmptyRandomString(String field) {
		  Random rnd = new Random();
			  return field + rnd.nextInt(10000);
	 }

}
