package com.example.tests;


import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

/**
 * Testing Contacts Modification functionality
 * 
 * @version 0.4
 */
public class ContactModificationTests extends TestBase{
	
	@Test(dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact) {
		
		//save old state
		SortedListOf<ContactData> oldList = app.getHibernateHelper().listContacts();
		
		Random rnd = new Random();
		int index = rnd.nextInt(oldList.size() - 1);
		
		app.getContactHelper().modifyContact(index, contact);
		
		//save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		
		//compare the states
		assertThat(newList, equalTo(oldList.without(index).withAdded(contact)));
		
	}
	
	//@Test
	public void addToGroupSomeContact() {
		app.getContactHelper().addToGroupContact(1);
			
	}

}
