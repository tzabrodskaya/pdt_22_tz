package com.example.tests;

import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;

/**
 * Testing the display of Address Book page
 * 
 * @version 0.2
 */
public class AddressBookTests extends TestBase{

	@Test
	public void displayAddressBook() {
		
		//get the list of contacts with data from database
		SortedListOf<ContactData> mainList = app.getHibernateHelper().listContacts();
		
		//get the list of contacts from AddressBook
		SortedListOf<ContactData> addressBookList = app.getContactHelper().getAddressBookContacts();
		
		//compare contacts
		assertThat(mainList, equalTo(addressBookList));
	}
}
