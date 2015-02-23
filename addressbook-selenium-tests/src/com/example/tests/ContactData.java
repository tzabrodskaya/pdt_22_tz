package com.example.tests;

/**
 *  Data for filling Contact form
 * 
 * @version 0.1
 */
public class ContactData {
	public String firstName;
	public String lastName;
	public String mainAddress;
	public String homeTel;
	public String mobileTel;
	public String workTel;
	public String mainEmail;
	public String secondaryEmail;
	public String bday = "-";
	public String bmonth = "-";
	public String byear;
	public String groupMember;
	public String secondaryAddress;
	public String secondaryPhone;

	public ContactData(String firstName, String lastName, String mainAddress,
			String homeTel, String mobileTel, String workTel, String mainEmail,
			String secondaryEmail, String bday, String bmonth, String byear,
			String groupMember, String secondaryAddress, String secondaryPhone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.mainAddress = mainAddress;
		this.homeTel = homeTel;
		this.mobileTel = mobileTel;
		this.workTel = workTel;
		this.mainEmail = mainEmail;
		this.secondaryEmail = secondaryEmail;
		this.bday = bday;
		this.bmonth = bmonth;
		this.byear = byear;
		this.groupMember = groupMember;
		this.secondaryAddress = secondaryAddress;
		this.secondaryPhone = secondaryPhone;
	}
	
	public ContactData() {
	}
}