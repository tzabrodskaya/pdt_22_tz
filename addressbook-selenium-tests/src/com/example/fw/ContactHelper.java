package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper to manipulate the contacts
 * @version 0.2
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
		//contacts start always with 2
		index += 2;
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
	
	//get list of contacts from main page
	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		
		//find checkboxes with group names as attribute
		List<WebElement> checkboxes = findElements(By.name("selected[]"));
		
		for (WebElement checkbox: checkboxes) {
			ContactData contact = new ContactData();
			
			//title contains First and Lastnames together with spaces, use relative xpath with id instead
			String id = checkbox.getAttribute("id");
			contact.id = Integer.parseInt(id.substring("id".length(), id.length()));
			contact.lastName = findElement(By.xpath("//input[@id='" + id + "']/../following-sibling::td[1]")).getText();
			contact.firstName = findElement(By.xpath("//input[@id='" + id + "']/../following-sibling::td[2]")).getText();
			//get phone as a 4th element (can by any if others are empty! 
			//contact.homeTel = findElement(By.xpath("//input[@id='" + id + "']/../following-sibling::td[4]")).getText();;
							
			contacts.add(contact);
		}
				
		return contacts;
	}

}
