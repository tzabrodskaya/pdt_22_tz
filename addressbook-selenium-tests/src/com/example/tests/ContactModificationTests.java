package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

/**
 * Testing Contacts Modification functionality
 * 
 * @version 0.6
 */
public class ContactModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		
		//save old state
		SortedListOf<ContactData> oldList = app.getModel().getContacts();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		
		//check edit form is correctly loaded from DB
		ContactData displayedContact = app.getContactHelper().getContactFromEditForm(index);
		assertThat(oldList.get(index), equalTo(displayedContact));
				
		app.getContactHelper().modifyContact(index, contact);
		
		//save new state
		SortedListOf<ContactData> newList = app.getModel().getContacts();
		
		//compare the Model states
		assertThat(newList, equalTo(oldList));
		
		//compare model to UI, DB, dbToUI if necessary
		checkContactStates();
		
	}
	
	//@Test
	public void addToGroupSomeContact() {
		app.getContactHelper().addToGroupContact(1);
			
	}

}
