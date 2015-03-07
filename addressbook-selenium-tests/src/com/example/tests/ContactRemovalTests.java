package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

/**
 * Testing Contact Deletion functionality
 * 
 * @version 0.2
 */
public class ContactRemovalTests extends TestBase{
	
	@Test
	public void removeSomeContact() {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		
	    //test only valid for not null groupList
		app.getContactHelper().initContactModification(index);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
		
		//save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
		
		//compare states
		oldList.remove(index);
		assertEquals(oldList, newList);
	}

}
