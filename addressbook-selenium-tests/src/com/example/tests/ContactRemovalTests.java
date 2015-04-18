package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

/**
 * Testing Contact Deletion functionality
 * 
 * @version 0.3
 */
public class ContactRemovalTests extends TestBase{
	
	@Test
	public void removeSomeContact() {
		
		//save old state
		SortedListOf<ContactData> oldList = app.getHibernateHelper().listContacts();
		
		Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
		
	    //test only valid for not null groupList
	    app.getContactHelper().contactDeletion(index);
		
		//save new state
		SortedListOf<ContactData> newList = app.getContactHelper().getContacts();
		
		//compare states
		assertThat(newList,equalTo(oldList.without(index)));
	}

}
