package com.example.tests;

import org.testng.annotations.Test;

/**
 * Testing Contact Deletion functionality
 * 
 * @author tzabrodskaya
 * @version 0.1
 */
public class ContactRemovalTests extends TestBase{
	
	@Test
	public void removeSomeGroup() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(1);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
	}

}
