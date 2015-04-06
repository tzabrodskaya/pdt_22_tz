package com.example.tests;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;
import com.example.utils.DateGenerator;

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
		  if (rnd.nextInt(5) == 0) {
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
		
		DateFormat df = new SimpleDateFormat("yyyyMMMM d", Locale.ENGLISH);
		String formattedDate;
		String bday;
		String bmonth;
		String byear;
		
		for (int i = 0; i < 5; i++) {
			
			Date generatedData = DateGenerator.generateDate(new GregorianCalendar(1940,1,1), new GregorianCalendar(2000,1,1));
			formattedDate = df.format(generatedData);
			bday = formattedDate.replaceAll("\\d+\\w+ ","");
			bmonth = formattedDate.replaceAll("[^a-zA-Z]","");
			byear = formattedDate.substring(0, 4);
			
			ContactData contact = new ContactData()
			.withFirstName(generateRandomString("FirstName"))
			.withLastName(generateRandomString("LastName"))
			.withMainAddress(generateRandomString("Address"))
			.withHomeTel("66" + generateRandomString(""))
			.withMobilTel(generateRandomString(""))
			.withWorkTel(generateRandomString(""))
			.withMainEmail("main" + generateRandomString("e-mail@gmail.com"))
			.withSecondaryEmail(generateRandomString("e-mail2@gmail.com"))
			.withBday(bday)
			.withBmonth(bmonth)
			.withByear(byear)
			.withGroupMember("")
			.withSecondaryAddress(generateRandomString("Secondary address"))
			.withSecondaryPhone(generateRandomString("5467789898"));
		    
		    list.add(new Object[]{contact});
		}
		
		return list.iterator();
	}
	
	

}
