package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

/**
 * Basic methods for initialization and stop the application manager for the specified browser
 * DataProvider are defined for groups
 * 
 * @version 0.3
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

	@DataProvider 
	public Iterator<Object[]> randomValidGroupGenerator() {
		  List<Object[]> list = new ArrayList<Object[]>();
		  
		  for (int i = 0; i < 5; i++) {
			  GroupData group = new GroupData();
			  group.name = generateRandomString("name");
			  group.header = generateRandomString("header");
			  group.footer = generateRandomString("footer");
			  list.add(new Object[]{group});
		  }
		  return list.iterator();
	  }
	  
	 public String generateRandomString(String field) {
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			  return "";
		  } else {
			  return field + " " + rnd.nextInt();
		  }
	  }
	

}
