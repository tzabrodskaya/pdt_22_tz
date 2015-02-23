package com.example.tests;

import org.testng.annotations.Test;

/**
 * Testing Contact Deletion functionality
 * 
 * @version 0.1
 */
public class ContactRemovalTests extends TestBase{
	
	@Test
	public void removeSomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(1);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
	}

}
