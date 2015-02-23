package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.GroupData;

/**
 * Helper to manipulate the groups
 * @version 0.1
 *
 */
public class GroupHelper extends HelperBase{
	
	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	//create
	public void initGroupCreation() {
		click(By.name("new"));
	}

	public void fillGroupForm(GroupData group) {
		type(By.name("group_name"), group.name);
		type(By.name("group_header"), group.header);
		type(By.name("group_footer"), group.footer);
	}

	public void submitGroupCreation() {
		click(By.name("submit"));
	}

	public void returnToGroupsPage() {
		click(By.linkText("group page"));
	}

	//update
	public void initGroupModification(int index) {
		selectGroupByIndex(index);	
		click(By.name("edit"));
	}

	public void submitGroupModification() {
		click(By.name("update"));	
	}

	private void selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
	}

	//delete
		public void deleteGroup(int index) {
			selectGroupByIndex(index);
			click(By.name("delete"));
		}
}
