package com.example.tests;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.*;

import static org.testng.Assert.assertEquals;

/**
 * Testing Contacts Creation functionality
 * 
 * @version 0.3
 */
public class ContactCreationTests extends TestBase{
  
  @Test(dataProvider = "randomValidContactGenerator")
  public void testNonEmptyContactCreation(ContactData contact) throws Exception {
	app.getNavigationHelper().openMainPage();
	
	//save old state - list of contacts
	List<ContactData> oldList = app.getContactHelper().getContacts();
	
    app.getContactHelper().initContactCreation();    
	app.getContactHelper().fillContactForm(contact,true);
    app.getContactHelper().submitContactCreation();
    app.getContactHelper().returnToHomePage();
    
    //save new state - list of contacts
    List<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    assertEquals(oldList.size()+1, newList.size());
    
    //contacts are sorted by their ids
    Collections.sort(oldList);
    oldList.add(contact);
    Collections.sort(newList);
    assertEquals(oldList, newList);
    
  }

}
