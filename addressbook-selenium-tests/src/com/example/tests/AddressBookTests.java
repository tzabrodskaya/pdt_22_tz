package com.example.tests;

import static org.junit.Assert.assertThat;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import com.example.utils.SortedListOf;

/**
 * Testing the display of Address Book page
 * 
 * @version 0.1
 */
public class AddressBookTests extends TestBase{

	@Test
	public void displayAddressBook() {
		
		//get the list of contacts with data from main page
		SortedListOf<ContactData> mainList = app.getContactHelper().getContacts();
		
		//get the list of contacts from AddressBook
		SortedListOf<ContactData> addressBookList = app.getContactHelper().getAddressBookContacts();
		
		//compare contacts
		assertThat(mainList, equalTo(addressBookList));
	}
}
