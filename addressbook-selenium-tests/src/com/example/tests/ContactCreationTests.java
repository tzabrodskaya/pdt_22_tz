package com.example.tests;

import org.testng.annotations.*;

/**
 * Testing Contacts functionality
 * 
 * @author tzabrodskaya
 * @version 0.1
 */
public class ContactCreationTests extends TestBase{
  
  @Test
  public void testNonEmptyContactCreation() throws Exception {
	openMainPage();
    initContactCreation();
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
	fillContactForm(contact);
    submitContactCreation();
    returnToHomePage();
  }

  
  @Test
  public void testEmptyContactCreation() throws Exception {
		openMainPage();
	    initContactCreation();
	    fillContactForm(new ContactData());
	    submitContactCreation();
	    returnToHomePage();
	  }

}
