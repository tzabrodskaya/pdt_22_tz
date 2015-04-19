package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

/**
 * Helper to manipulate the groups
 * 
 * @version 0.5
 *
 */
public class GroupHelper extends WebDriverHelperBase{
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}
	
	public GroupHelper createGroup(GroupData group) {
		initGroupCreation();
    	fillGroupForm(group);
    	submitGroupCreation();
    	returnToGroupsPage();
    	// update model
    	manager.getModel().addGroup(group);
    	return this;
	}
	
	public GroupHelper modifyGroup(int index, GroupData group) {
		initGroupModification(index);
		fillGroupForm(group);
		submitGroupModification();
		returnToGroupsPage();
		manager.getModel().removeGroup(index).addGroup(group);
		return this;
		
	}

	//delete
	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupsPage();
		manager.getModel().removeGroup(index);
		return this;
	}
		
	//return the list of the groups from the Groups page
	public SortedListOf<GroupData> getUIGroups() {
	
		SortedListOf<GroupData> groups = new SortedListOf<GroupData>();
		
		manager.navigateTo().groupsPage();
		//find checkboxes with group names as attribute
		List<WebElement> checkboxes = findElements(By.name("selected[]"));
		
		for (WebElement checkbox: checkboxes) {
			String title =  checkbox.getAttribute("title");
			String name = title.substring("Select (".length(), title.length() - ")".length());
			groups.add(new GroupData().withName(name));
		}
		
		return groups;
	}
	
	//----------------------------------------------------------------------------------------------------
	//create
	public GroupHelper initGroupCreation() {
		manager.navigateTo().groupsPage();
		click(By.name("new"));
		return this;
	}
		

	public GroupHelper fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.getName());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}
	
	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));
		return this;
	}

	public GroupHelper returnToGroupsPage() {
		click(By.linkText("group page"));
		return this;
	}

	//update
	public GroupHelper initGroupModification(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);	
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));
		return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index + 1) + "]"));
		return this;
	}


	public GroupHelper submitGroupDeletion() {
		click(By.name("delete"));
		return this;
	}
	

	

	
}
