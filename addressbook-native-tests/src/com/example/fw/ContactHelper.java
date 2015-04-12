package com.example.fw;


/**
 * Helper to manipulate the contacts
 * @version 0.1
 *
 */
public class ContactHelper extends HelperBase{


	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void createContact(Contact contact) {
		initContactCreation();
		fillContactForm(contact);
		confirmContactCreation();
	}	

	public void deleteFirstContact(){
		selectFirstContact();
		initSelectedContactDeletion();
		confirmContactDeletion();
	}
	
	public void checkEmptyContactsList(){
		selectFirstContact();
		initContactEditWarning();
	}

	public Contact getFirstContact(){
		selectFirstContact();
		initContactEdit();
		Contact contact = new Contact()
		 	.setFirstName(manager.getAutoItHelper().getText("TDBEdit12"))
		 	.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		cancellContactEdit();
		return contact;
	}

//----------------------------------------------------------------------------------------------------------------------------------

	private void initContactCreation() {
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("Add")
			.winWaitAndActivate("Add Contact", "", 5000);
	}
	
	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
		 	.send("TDBEdit12", contact.getFirstName())
		 	.send("TDBEdit11", contact.getLastName());
	}

	private void confirmContactCreation() {
		manager.getAutoItHelper()
			.click("Save")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	private void selectFirstContact() {
		manager.getAutoItHelper()
		  	.winWaitAndActivate("AddressBook Portable", "", 5000)
		  	.click("TListView1")
		  	.send("{DOWN}{SPACE}");
	}
	
	private void initContactEdit() {
		manager.getAutoItHelper()
		  	.click("Edit")
		  	.winWaitAndActivate("Update Contact", "", 5000);
	}

	private void initContactEditWarning() {
		manager.getAutoItHelper()
	  	.click("Edit")
	  	.winWaitAndActivate("Information", "", 5000)
	  	.click("TButton1");
		
	}

	private void cancellContactEdit(){
		manager.getAutoItHelper()
			.click("Cancel");
	}
	
	private void initSelectedContactDeletion() {
		manager.getAutoItHelper()
			.click("Delete")
			.winWaitAndActivate("Confirm", "", 5000);
	}
	
	private void confirmContactDeletion() {
		manager.getAutoItHelper()
			.click("TButton2")
			.winWaitAndActivate("AddressBook Portable", "", 5000);
	}



}
