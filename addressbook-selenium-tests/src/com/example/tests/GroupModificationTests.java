package com.example.tests;

import org.testng.annotations.Test;

/**
 * Testing Groups Modification functionality
 * 
 * @author tzabrodskaya
 * @version 0.1
 */
public class GroupModificationTests extends TestBase{


	@Test
	public void modifySomeGroup() {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.name = "new name";
		app.getGroupHelper().fillGroupForm(group );
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupsPage();
	}

}
