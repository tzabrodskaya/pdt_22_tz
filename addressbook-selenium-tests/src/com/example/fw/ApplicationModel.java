package com.example.fw;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

/**
 * Model of Application, contains Group and Contact data
 * 
 * @version 0.1
 *
 */

public class ApplicationModel {
	
	private SortedListOf<GroupData> groups;
	private SortedListOf<ContactData> contacts;
	
	//groups
	public SortedListOf<GroupData> getGroups() {
		return groups;
	}
	
	public void setGroups(SortedListOf<GroupData> groups) {
		this.groups = new SortedListOf<GroupData>(groups);
	}

	public ApplicationModel addGroup(GroupData group) {
		groups.add(group);		
		return this;
	}

	public ApplicationModel removeGroup(int index) {
		groups.remove(index);
		return this;
	}
	
	//contacts
	public SortedListOf<ContactData> getContacts() {
		return contacts;
	}
	
	public void setContacts(SortedListOf<ContactData> contacts) {
		this.contacts = new SortedListOf<ContactData>(contacts);
	}

	public ApplicationModel addContact(ContactData contact) {
		contacts.add(contact);		
		return this;
	}

	public ApplicationModel removeContact(int index) {
		contacts.remove(index);
		return this;
	}

}
