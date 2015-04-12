package com.example.tests;

import org.testng.annotations.Test;


/**
 * Testing Contacts Removal functionality
 * 
 * @version 0.1
 */
public class ContactRemovalTests extends TestBase{

	@Test
	public void shouldRemoveFirstContact() throws Exception {
		app.getContactHelper().deleteFirstContact();
		app.getContactHelper().checkEmptyContactsList();
	}
}
