package com.example.tests;

import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.*;

/**
 * Testing Groups Creation functionality with assertion
 * 
 * @version 0.3
 */
public class GroupCreationTests extends TestBase{
 
  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().gotoGroupsPage();
    
    //save old state - list of groups
    List<GroupData> oldList = app.getGroupHelper().getGroups();
    
    //actions
    app.getGroupHelper().initGroupCreation();
	app.getGroupHelper().fillGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupsPage();
    
    //save new state
    List<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare states
    //assertEquals(newList.size(), oldList.size() + 1);
    
    oldList.add(group);
    Collections.sort(oldList);
    assertEquals(oldList, newList);
  }

}
