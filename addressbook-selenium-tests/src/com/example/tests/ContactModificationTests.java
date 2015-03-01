package com.example.tests;

import org.testng.annotations.Test;

/**
 * Testing Contacts Modification functionality
 * 
 * @version 0.1
 */
public class ContactModificationTests extends TestBase{
	
	@Test
	public void modifySomeContact() {
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().initContactModification(1);
		ContactData contact = new ContactData();
		contact.mainAddress = "new address";
		contact.mainEmail = "new email";
		contact.mobileTel ="54566677";
		app.getContactHelper().fillContactForm(contact,false);
		app.getContactHelper().submitContactModification();
		app.getContactHelper().returnToHomePage();
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
