package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;

import java.util.List;

/**
 * Helper to manipulate the contacts
 * 
 * @version 0.7
 *
 */
public class ContactHelper extends WebDriverHelperBase{
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public ContactHelper createContact(ContactData contact) {
		initContactCreation();    
    	fillContactForm(contact,CREATION);
    	submitContactCreation();
    	returnToHomePage();
    	// update model
    	manager.getModel().addContact(contact);
		return this;
	}
	
	public ContactData getContactFromEditForm(int index) {
		initContactModification(index);
		return readContactForm();
	}

	public ContactHelper modifyContact(int index, ContactData contact) {
		initContactModification(index);
		fillContactForm(contact,MODIFICATION);
		submitContactModification();
		returnToHomePage();
		manager.getModel().removeContact(index).addContact(contact);
		return this;
		
	}
	
	public ContactHelper addToGroupContact(int index) {
		manager.navigateTo().mainPage();
		selectContactByIndex(index);
		addToGroup("");
		manager.navigateTo().mainPage();
		return this;
		
	}
	
	public ContactHelper contactDeletion(int index) {
		initContactModification(index);
		deleteContact();
		returnToHomePage();
		manager.getModel().removeContact(index);
		return this;
		
	}
	
	//get list of contacts from main page	
	public SortedListOf<ContactData> getUIContacts() {
		SortedListOf<ContactData> contacts = new SortedListOf<ContactData>();
		
		manager.navigateTo().mainPage();
		//find rows with contact information
		List<WebElement> rows = findElements(By.name("entry"));
		
		for (WebElement row: rows) {
			
			//title contains First and LastNames together with spaces, use relative xpath with id instead
			String id = row.findElement(By.xpath(".//td[1]/input")).getAttribute("id");
			Integer contactId = Integer.parseInt(id.replace("id",""));
			String lastName = row.findElement(By.xpath(".//td[2]")).getText();
		    String firstName = row.findElement(By.xpath(".//td[3]")).getText();
			String mainEmail = row.findElement(By.xpath(".//td[4]")).getText();
			String homeTel = row.findElement(By.xpath(".//td[5]")).getText();
			
							
			contacts.add(new ContactData()
				.withFirstName(firstName)
				.withLastName(lastName)
				.withId(contactId)
				.withHomeTel(homeTel)
				.withMainEmail(mainEmail));
	
		} 
			
		return contacts;
	}
	
	//get list of contacts from AddressBook page
	public SortedListOf<ContactData> getAddressBookContacts() {
		SortedListOf<ContactData> listAddressBook = new SortedListOf<ContactData>();
		
		manager.navigateTo().addressBookPage();
		
		List<WebElement> rows = findElements(By.xpath(".//*[@valign='top']"));
		
		for (WebElement row: rows) {
			String names = row.findElement(By.xpath("./b")).getText();
			String firstName = (names == "" || !names.contains("First")) ? "" : getFirstName(names);
			String lastName = (names == "" || !names.contains("Last")) ? "" : names.substring(names.indexOf("L"), names.length());
			String mainEmail = "";
			try {
				mainEmail = row.findElement(By.xpath(".//a[1]")).getText();
			} catch (NoSuchElementException e) {
			}
			
			String rowText = row.getText();
			String homeTel = rowText.contains("H:") ? rowText.substring(rowText.indexOf("H: ") + 3, rowText.indexOf("\n", rowText.indexOf("H: "))) : "";
			
			
			listAddressBook.add(new ContactData()
				.withFirstName(firstName)
				.withLastName(lastName)
				.withHomeTel(homeTel)
				.withMainEmail(mainEmail));
		}
		
		
		System.out.println(driver.getCurrentUrl());
		return listAddressBook;
	}

	//get Contact from Contact Form
			private ContactData readContactForm() {
				
				String firstName = getValueByName("firstname");
				String lastName = getValueByName("lastname");
				String homeTel = getValueByName("home");
				String mainEmail = getValueByName("email");
				return new ContactData()
						.withFirstName(firstName)
						.withLastName(lastName)
						.withHomeTel(homeTel)
						.withMainEmail(mainEmail);
	}
//----------------------------------------------------------------------------------------------------------------------------------

	private String getFirstName(String names) {
		return !names.contains("Last") ? names : names.substring(0, names.indexOf(" "));
	}
	
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
	    return this;
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
	    return this;
	}

	//update
	public ContactHelper initContactModification(int index) {
		manager.navigateTo().mainPage();
		//contacts start always with 2
		index += 2;
		click(By.xpath(".//*[@id='maintable']//tr[" + index + "]/td[7]//img"));
	    return this;
	}
	
	public ContactHelper submitContactModification() {
		click(By.xpath("//input[@value='Update']"));
	    return this;
		
	}

	//delete
	public ContactHelper deleteContact() {
		click(By.xpath("//input[@value='Delete']"));
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
