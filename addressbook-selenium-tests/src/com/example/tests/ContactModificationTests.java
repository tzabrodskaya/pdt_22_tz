package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

/**
 * Testing Contacts Modification functionality
 * 
 * @version 0.2
 */
public class ContactModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		app.getNavigationHelper().openMainPage();
		
		//save old state
		List<ContactData> oldList = app.getContactHelper().getContacts();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		
		app.getContactHelper().initContactModification(index);
		contact.id = oldList.get(index).id;
		app.getContactHelper().fillContactForm(contact,false);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
		
		//save new state
		List<ContactData> newList = app.getContactHelper().getContacts();
		
		//compare the states
		oldList.set(index, contact);
		Collections.sort(oldList);
		Collections.sort(newList);
		assertEquals(newList,oldList);
		
	}
	
	@Test
	public void addToGroupSomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().selectContactByIndex(1);
		////TODO - list of current groups
		app.getContactHelper().addToGroup("");
		app.getNavigationHelper().openMainPage();
	}

}
