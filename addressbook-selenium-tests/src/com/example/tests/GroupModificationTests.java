package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

/**
 * Testing random Groups Modification functionality
 *
 * @version 0.4
 */
public class GroupModificationTests extends TestBase{


	@Test (dataProvider = "randomValidGroupGenerator")
	public void modifySomeGroup(GroupData group) {
		
	    //save old state
		SortedListOf<GroupData> oldList = app.getModel().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
	    //actions
		app.getGroupHelper().modifyGroup(index, group);
			
		//save new state
		SortedListOf<GroupData> newList = app.getModel().getGroups();
		
		//compare Model states
		assertThat(newList, equalTo(oldList));
		
		//compare model to UI, DB, dbToUI if necessary
	    checkGroupStates();
	}

}
