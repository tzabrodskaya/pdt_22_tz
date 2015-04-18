package com.example.tests;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.*;

import com.example.utils.SortedListOf;

import static com.example.tests.ContactDataGenerator.loadContactsFromXMLFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Testing Contacts Creation functionality
 * 
 * @version 0.7
 */

public class ContactCreationTests extends TestBase{
  
  @DataProvider
  public Iterator<Object[]> contactsFromFile() throws IOException {
		return wrapContactsForDataProvider(loadContactsFromXMLFile(new File(app.getProperty("contactsDataFile")))).iterator();
		// TODO file name to property file
  }
	

//@Test(dataProvider = "randomValidContactGenerator")
  @Test(dataProvider = "contactsFromFile")
  public void testNonEmptyContactCreation(ContactData contact) {
	
	//save old state - list of contacts
	SortedListOf<ContactData> oldList = app.getHibernateHelper().listContacts();
	
	//actions
	app.getContactHelper().createContact(contact);
    
    //save new state - list of contacts
    SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
    
    // compare states
    assertThat(newList, equalTo(oldList.withAdded(contact)));
    
    //compare that display of contacts is according to DB data
    assertThat(newList, equalTo(app.getHibernateHelper().listContacts()));
   
    
  }

}
