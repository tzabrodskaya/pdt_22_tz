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
 * @version 0.5
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
			  GroupData group = new GroupData()
			  		  .withName(generateRandomString("name"))
					  .withHeader(generateRandomString("header"))
					  .withFooter(generateRandomString("footer"));
			  list.add(new Object[]{group});
		  }
		  return list.iterator();
	  }
	
	// data provider for contacts
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		
		String months[] = {"January", "February", "March", "April",
                "May", "June", "July", "August", "September",
                "October", "November", "December"};
		Random b = new Random();
		
		for (int i = 0; i < 5; i++) {
			
			Integer bday = b.nextInt(28) + 1;
			Integer bmonth = b.nextInt(12) + 1;
		    Integer byear = b.nextInt(80) + 1910;
		    
			ContactData contact = new ContactData()
			.withFirstName(generateRandomString("First Name"))
			.withLastName(generateRandomString("Last name"))
			.withMainAddress(generateRandomString("Address"))
			.withHomeTel(generateRandomString(""))
			.withMobilTel(generateRandomString(""))
			.withWorkTel(generateRandomString(""))
			.withMainEmail(generateRandomString("e-mail@gmail.com"))
			.withSecondaryEmail(generateRandomString("e-mail2@gmail.com"))
			.withBday(bday.toString())
			.withBmonth(months[bmonth])
			.withByear(byear.toString())
			.withGroupMember("")
			.withSecondaryAddress(generateRandomString("Secondary address"))
			.withSecondaryPhone(generateRandomString("5467789898"));
		    
		    list.add(new Object[]{contact});
		}
		
		return list.iterator();
	}
	
	

}
