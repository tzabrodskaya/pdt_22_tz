package com.example.tests;

import org.testng.annotations.*;

/**
 * Testing Groups functionality
 * 
 * @author tzabrodskaya
 * @version 0.1
 */
public class GroupCreationTests extends TestBase{
 
  @Test
  public void testNonEmptyGroupCreation() throws Exception {
	openMainPage();
    gotoGroupsPage();
    initGroupCreation();
    GroupData group = new GroupData();
    group.name = "group 1";
    group.header = "header 1";
    group.footer = "footer 1";
	fillGroupForm(group);
    submitGroupCreation();
    returnToGroupsPage();
  }

  @Test
  public void testEmptyGroupCreation() throws Exception {
		openMainPage();
	    gotoGroupsPage();
	    initGroupCreation();
	    fillGroupForm(new GroupData());
	    submitGroupCreation();
	    returnToGroupsPage();
	  }
}
