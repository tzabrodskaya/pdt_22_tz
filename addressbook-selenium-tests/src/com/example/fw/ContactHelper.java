package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

/**
 * Helper to manipulate the contacts
 * @version 0.1
 *
 */
public class ContactHelper extends HelperBase{

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	//create
	public void initContactCreation() {
	    click(By.linkText("add new"));
	}

	public void fillContactForm(ContactData contact, boolean selectGroup) {
	    type(By.name("firstname"), contact.firstName);
	    type(By.name("lastname"), contact.lastName);
	    type(By.name("address"), contact.mainAddress);
	    type(By.name("home"), contact.homeTel);
	    type(By.name("mobile"), contact.mobileTel);
	    type(By.name("work"), contact.workTel);
	    type(By.name("email"), contact.mainEmail);
	    type(By.name("email2"), contact.secondaryEmail);
	    selectByText(By.name("bday"), contact.bday);
	    selectByText(By.name("bmonth"), contact.bmonth);
	    type(By.name("byear"), contact.byear);
	    if (selectGroup) {
	    	selectByText(By.name("new_group"), contact.groupMember);
	    }
	    type(By.name("address2"), contact.secondaryAddress);
	    type(By.name("phone2"), contact.secondaryPhone);
	}

	public void submitContactCreation() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	//update
	public void initContactModification(int index) {
		//the contacts on page starts with index 2, e.g. the first contact is on row 2
		++index;
		click(By.xpath(".//*[@id='maintable']//tr[" + index + "]/td[7]//img"));
	}
	
	public void submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		
	}

	//delete
	public void deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
		
	}
	
	//add to group
	public void selectContactByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
		
	}

	public void addToGroup(String group) {
		selectByText(By.name("to_group"), group);
		click(By.name("add"));
		
	}

}
