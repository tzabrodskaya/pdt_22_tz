package com.example.tests;

import static org.testng.AssertJUnit.assertEquals;

import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

/**
 * Testing random Group Deletion functionality
 * 
 * @version 0.2
 */
public class GroupRemovalTests extends TestBase{
	
	
	@Test
	public void deleteSomeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    
	    //save old state
	    List<GroupData> oldList = app.getGroupHelper().getGroups();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldList.size() - 1);
	    
	    //test only valid for not null groupList
		app.getGroupHelper().deleteGroup(index);
		app.getGroupHelper().returnToGroupsPage();
		
		//save new state
		List<GroupData> newList = app.getGroupHelper().getGroups();
		
		//compare states
		oldList.remove(index);
		assertEquals(newList, oldList);
	
	}

}
