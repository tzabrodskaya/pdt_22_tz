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
 * DataProvider are defined for groups and contacts
 * 
 * @version 0.4
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


	public String generateRandomString(String field) {
		  Random rnd = new Random();
		  if (rnd.nextInt(3) == 0) {
			  return "";
		  } else {
			  return field + rnd.nextInt();
		  }
	 }
	 
	// data provider for groups
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
	
	// data provider for contacts
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		for (int i = 0; i < 5; i++) {
			ContactData contact = new ContactData();
		    contact.firstName = generateRandomString("First Name");;
		    contact.lastName = generateRandomString("Last name");
		    contact.mainAddress = generateRandomString("Address");
		    contact.homeTel = generateRandomString("");
		    contact.mobileTel = generateRandomString("");
		    contact.workTel = generateRandomString("");
		    contact.mainEmail = generateRandomString("e-mail@gmail.com");
		    contact.secondaryEmail = generateRandomString("e-mail2@gmail.com");
		    
		    Integer bday = new Random().nextInt(28) + 1;
		    contact.bday = bday.toString();
		    
		    String months[] = {"January", "February", "March", "April",
                    "May", "June", "July", "August", "September",
                    "October", "November", "December"};
		    Integer bmonth = new Random().nextInt(12)+1;
		    contact.bmonth = months[bmonth];
		    
		    Integer byear = new Random().nextInt(80) + 1910;
		    contact.byear = byear.toString();
		    //TODO - list of current groups
		    contact.groupMember = "";
		    contact.secondaryAddress = generateRandomString("Secondary address");
		    contact.secondaryPhone = generateRandomString("5467789898");
		    
		    list.add(new Object[]{contact});
		}
		
		return list.iterator();
	}
	
	

}
