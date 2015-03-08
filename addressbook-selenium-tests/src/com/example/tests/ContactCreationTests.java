package com.example.tests;

import org.testng.annotations.*;

import com.example.utils.SortedListOf;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Testing Contacts Creation functionality
 * 
 * @version 0.4
 */
public class ContactCreationTests extends TestBase{
  
  @Test(dataProvider = "randomValidContactGenerator")
  public void testNonEmptyContactCreation(ContactData contact) {
	
	//save old state - list of contacts
	SortedListOf<ContactData> oldList = app.getContactHelper().getContacts();
	
	//actions
	app.getContactHelper().createContact(contact);
    
    //save new state - list of contacts
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    assertThat(newList, equalTo(oldList.withAdded(contact)));
   
    
  }

}
