package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

import java.util.List;

/**
 * Helper to manipulate the contacts
 * @version 0.3
 *
 */
public class ContactHelper extends HelperBase{
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	private SortedListOf<ContactData> cachedContacts;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public ContactHelper createContact(ContactData contact) {
		initContactCreation();    
    	fillContactForm(contact,CREATION);
    	submitContactCreation();
    	returnToHomePage();
    	rebuildCache();
		return this;
	}
	

	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModification(index);
		fillContactForm(contact,MODIFICATION);
		submitContactModification();
		returnToHomePage();
		rebuildCache();
		return this;
		
	}
	
	public ContactHelper addToGroupContact(int index) {
		selectContactByIndex(index);
		addToGroup("");
		manager.navigateTo().mainPage();
		return this;
		
	}
	
	public ContactHelper contactDeletion(int index) {
		initContactModification(index);
		deleteContact();
		returnToHomePage();
		rebuildCache();
		return this;
		
	}
	
	//get list of contacts from main page		
	public SortedListOf<ContactData> getContacts() {
		if (cachedContacts == null) {
			rebuildCache();
		}
		return cachedContacts;
	}
		
	private void rebuildCache() {
		cachedContacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();
		//find checkboxes with group names as attribute
		List<WebElement> checkboxes = findElements(By.name("selected[]"));
		
		for (WebElement checkbox: checkboxes) {
			
			//title contains First and Lastnames together with spaces, use relative xpath with id instead
			String id = checkbox.getAttribute("id");
			Integer contactId = Integer.parseInt(id.substring("id".length(), id.length()));
			String lastName = findElement(By.xpath("//input[@id='" + id + "']/../following-sibling::td[1]")).getText();
			String firstName = findElement(By.xpath("//input[@id='" + id + "']/../following-sibling::td[2]")).getText();
			//get phone as a 4th element (can by any if others are empty! 
			//contact.homeTel = findElement(By.xpath("//input[@id='" + id + "']/../following-sibling::td[4]")).getText();;
							
			cachedContacts.add(new ContactData().withFirstName(firstName).withLastName(lastName).withId(contactId));
		}
			
	}
	
	
//----------------------------------------------------------------------------------------------------------------------------------

	//create
	public ContactHelper initContactCreation() {
		manager.navigateTo().mainPage();
	    click(By.linkText("add new"));
	    return this;
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
	    type(By.name("firstname"), contact.getFirstName());
	    type(By.name("lastname"), contact.getLastName());
	    type(By.name("address"), contact.getMainAddress());
	    type(By.name("home"), contact.getHomeTel());
	    type(By.name("mobile"), contact.getMobileTel());
	    type(By.name("work"), contact.getWorkTel());
	    type(By.name("email"), contact.getMainEmail());
	    type(By.name("email2"), contact.getSecondaryEmail());
	    selectByText(By.name("bday"), contact.getBday());
	    selectByText(By.name("bmonth"), contact.getBmonth());
	    type(By.name("byear"), contact.getByear());
	    if (formType == CREATION) {
	    	selectByText(By.name("new_group"), contact.getGroupMember());
	    } else {
	    	//if(findElements(By.name("new_group")).size() != 0) {
	    	//	throw new Error("Group selector exists in contact modification form");
	    	//}
	    }
	    type(By.name("address2"), contact.getSecondaryAddress());
	    type(By.name("phone2"), contact.getSecondaryPhone());
	    return this;
	}

	public ContactHelper submitContactCreation() {
		click(By.name("submit"));
		cachedContacts = null;
	    return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
	    return this;
	}

	//update
	public ContactHelper initContactModification(int index) {
		//contacts start always with 2
		index += 2;
		click(By.xpath(".//*[@id='maintable']//tr[" + index + "]/td[7]//img"));
	    return this;
	}
	
	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
		cachedContacts = null;
	    return this;
		
	}

	//delete
	public ContactHelper deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
		cachedContacts = null;
	    return this;
		
	}
	
	//add to group
	public ContactHelper selectContactByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + index + "]"));
	    return this;
		
	}

	public ContactHelper addToGroup(String group) {
		selectByText(By.name("to_group"), group);
		click(By.name("add"));
	    return this;
		
	}

}
