package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;


import org.testng.annotations.*;

import com.example.utils.SortedListOf;

/**
 * Testing Groups Creation functionality with assertion
 * 
 * @version 0.4
 */
public class GroupCreationTests extends TestBase{

  @Test(dataProvider = "randomValidGroupGenerator")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    //save old state - list of groups
	 SortedListOf<GroupData> oldList = app.getGroupHelper().getGroups();
	
    //actions
    app.getGroupHelper().createGroup(group);
    
    //save new state
    SortedListOf<GroupData> newList = app.getGroupHelper().getGroups();
    
    // compare states
    assertThat(newList, equalTo(oldList.withAdded(group)));
  }

}
