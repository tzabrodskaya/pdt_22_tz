package com.example.tests;

import org.testng.annotations.Test;

/**
 * Testing Group Deletion functionality
 * 
 * @author tzabrodskaya
 * @version 0.1
 */
public class GroupRemovalTests extends TestBase{
	
	
	@Test
	public void deleteSomeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().deleteGroup(1);
		app.getGroupHelper().returnToGroupsPage();
	}

}
