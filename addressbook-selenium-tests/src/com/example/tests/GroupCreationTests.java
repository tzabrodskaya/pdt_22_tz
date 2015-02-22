package com.example.tests;

import org.testng.annotations.*;

/**
 * Testing Groups Creation functionality
 * 
 * @author tzabrodskaya
 * @version 0.2
 */
public class GroupCreationTests extends TestBase{
 
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    app.getGroupHelper().initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group 1";
    group.header = "header 1";
    group.footer = "footer 1";
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    app.getGroupHelper().initGroupCreation();
	    app.getGroupHelper().fillGroupForm(new GroupData("","",""));
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupsPage();
	  }
}
