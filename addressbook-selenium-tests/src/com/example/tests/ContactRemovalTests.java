package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

/**
 * Testing Contact Deletion functionality
 * 
 * @version 0.5
 */
public class ContactRemovalTests extends TestBase{
	
	@Test
	public void removeSomeContact() {
		
		//save old state
		SortedListOf<ContactData> oldList = app.getModel().getContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		
	    //test only valid for not null groupList
	    app.getContactHelper().contactDeletion(index);
		
		//save new state
		SortedListOf<ContactData> newList = app.getModel().getContacts();
		
		//compare Model states
		assertThat(newList,equalTo(oldList));
		
		//compare model to UI, DB, dbToUI if necessary
		checkContactStates();
	}

}
