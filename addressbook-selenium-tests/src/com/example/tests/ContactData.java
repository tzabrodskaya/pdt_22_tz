package com.example.tests;

/**
 *  Data for filling Contact form
 * 
 * @version 0.2
 */
public class ContactData implements Comparable<ContactData>{
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
	public Integer id;

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
	
	//Overridden basic methods, needed for compare, order and display
	@Override
	public String toString() {
		return "ContactData [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", mainAddress=" + mainAddress + ", homeTel=" + homeTel
				+ ", mobileTel=" + mobileTel + ", workTel=" + workTel
				+ ", mainEmail=" + mainEmail + ", secondaryEmail="
				+ secondaryEmail + ", bday=" + bday + ", bmonth=" + bmonth
				+ ", byear=" + byear + ", groupMember=" + groupMember
				+ ", secondaryAddress=" + secondaryAddress
				+ ", secondaryPhone=" + secondaryPhone + "]";
	}
	
	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		/*result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((homeTel == null) ? 0 : homeTel.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((mainEmail == null) ? 0 : mainEmail.hashCode());
		result = prime * result
				+ ((secondaryEmail == null) ? 0 : secondaryEmail.hashCode());
		*/
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.id.compareTo(other.id);
	}

	
}