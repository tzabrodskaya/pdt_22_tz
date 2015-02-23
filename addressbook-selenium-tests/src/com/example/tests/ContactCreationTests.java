package com.example.tests;

import org.testng.annotations.*;

/**
 * Testing Contacts Creation functionality
 * 
 * @version 0.2
 */
public class ContactCreationTests extends TestBase{
  
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
    contact.firstName = "First name";
    contact.lastName = "Last name";
    contact.mainAddress = "Address 1";
    contact.homeTel = "789654321";
    contact.mobileTel = "123456789";
    contact.workTel = "2223334455";
    contact.mainEmail = "e-mail@gmail.com";
    contact.secondaryEmail = "e-mail2@gmail.com";
    contact.bday = "1";
    contact.bmonth = "January";
    contact.byear = "1966";
    contact.groupMember = "group 1";
    contact.secondaryAddress = "Secondary address";
    contact.secondaryPhone = "5467789898";
	app.getContactHelper().fillContactForm(contact,true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
  }

  
  @Test
  public void testEmptyContactCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getContactHelper().initContactCreation();
	    ContactData contact = new ContactData();
	    contact.firstName = "";
	    contact.lastName = "";
	    contact.mainAddress = "";
	    contact.homeTel = "";
	    contact.mobileTel = "";
	    contact.workTel = "";
	    contact.mainEmail = "";
	    contact.secondaryEmail = "";
	    contact.byear = "";
	    contact.groupMember = "";
	    contact.secondaryAddress = "";
	    contact.secondaryPhone = "";
	    app.getContactHelper().fillContactForm(contact,false);
	    app.getContactHelper().submitContactCreation();
	    app.getContactHelper().returnToHomePage();
	  }

}
