package com.example.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.fw.Contact;

/**
 * Testing Contacts Creation functionality
 * 
 * @version 0.1
 */
public class ContactCreationTests extends TestBase{

	@Test
	public void shouldCreateContactWithValidData() throws Exception {
		Contact contact = new Contact().setFirstName("firstName").setLastName("lastName");
		app.getContactHelper().createContact(contact);
		Contact createdContact = app.getContactHelper().getFirstContact();
		Assert.assertEquals(contact,createdContact);
	}
}
