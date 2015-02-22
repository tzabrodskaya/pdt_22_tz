package com.example.tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

/**
 * Basic methods for initialization and stop the application manager for the specified browser
 * @author tzabrodskaya
 * @version 0.2
 *
 */
public abstract class TestBase {
	
	protected static ApplicationManager app;


	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager("FF");
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	  }

	
	
	

}
