package com.example.tests;

import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.*;

import com.example.utils.SortedListOf;

/**
 * Testing Groups Creation functionality with assertion
 * 
 * @version 0.8
 */
public class GroupCreationTests extends TestBase{

 // data provider for groups from generated file
 @DataProvider 
 public Iterator<Object[]> groupsFromFile() throws IOException {
		return wrapGroupsForDataProvider(loadGroupsFromCsvFile(new File(app.getProperty("groupsDataFile")))).iterator();
 }

//@Test(dataProvider = "randomValidGroupGenerator")
  @Test(dataProvider = "groupsFromFile")
  public void testGroupCreationWithValidData(GroupData group) throws Exception {
    //save old state - list of groups
	 SortedListOf<GroupData> oldList = app.getModel().getGroups();
	
    //actions
    app.getGroupHelper().createGroup(group);
    
    //save new state
    SortedListOf<GroupData> newList = app.getModel().getGroups();
    
    // compare Model states
    assertThat(newList, equalTo(oldList));
    
    //compare model to UI, DB, dbToUI if necessary
    checkGroupStates();
  }
  
}
