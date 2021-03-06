package com.example.tests;

import org.apache.commons.lang3.StringUtils;

/**
 *  Data for filling Contact form with overridden basic methods
 * 
 * @version 0.5
 */
public class ContactData implements Comparable<ContactData>{
	private String firstName;
	private String lastName;
	private String mainAddress;
	private String homeTel;
	private String mobileTel;
	private String workTel;
	private String mainEmail;
	private String secondaryEmail;
	private String bday = "-";
	private String bmonth = "-";
	private String byear;
	private String groupMember;
	private String secondaryAddress;
	private String secondaryPhone;
	private Integer id;

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
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setMainAddress(String mainAddress) {
		this.mainAddress = mainAddress;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}

	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}

	public void setWorkTel(String workTel) {
		this.workTel = workTel;
	}

	public void setMainEmail(String mainEmail) {
		this.mainEmail = mainEmail;
	}

	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}

	public void setBday(String bday) {
		this.bday = bday;
	}

	public void setBmonth(String bmonth) {
		this.bmonth = bmonth;
	}

	public void setByear(String byear) {
		this.byear = byear;
	}

	public void setGroupMember(String groupMember) {
		this.groupMember = groupMember;
	}

	public void setSecondaryAddress(String secondaryAddress) {
		this.secondaryAddress = secondaryAddress;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMainAddress() {
		return mainAddress;
	}

	public String getHomeTel() {
		return homeTel;
	}

	public String getMobileTel() {
		return mobileTel;
	}

	public String getWorkTel() {
		return workTel;
	}

	public String getMainEmail() {
		return mainEmail;
	}

	public String getSecondaryEmail() {
		return secondaryEmail;
	}

	public String getBday() {
		return bday;
	}

	public String getBmonth() {
		return bmonth;
	}

	public String getByear() {
		return byear;
	}

	public String getGroupMember() {
		return groupMember;
	}

	public String getSecondaryAddress() {
		return secondaryAddress;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public Integer getId() {
		return id;
	}

		//setting local variables
		public ContactData withFirstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public ContactData withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public ContactData withMainAddress(String Address) {
			mainAddress = Address;
			return this;
		}

		public ContactData withHomeTel(String homeTel) {
			this.homeTel = homeTel;
			return this;
		}

		public ContactData withMobilTel(String mobilTel) {
			mobileTel = mobilTel;
			return this;
		}

		public ContactData withWorkTel(String workTel) {
			this.workTel = workTel;
			return this;
		}

		public ContactData withMainEmail(String mainEmail) {
			this.mainEmail = mainEmail;
			return this;
		}

		public ContactData withSecondaryEmail(String secondaryEmail) {
			this.secondaryEmail = secondaryEmail;
			return this;
		}

		public ContactData withBday(String bday) {
			this.bday = bday;
			return this;
		}

		public ContactData withBmonth(String bmonth) {
			this.bmonth = bmonth;
			return this;
		}

		public ContactData withByear(String byear) {
			this.byear = byear;
			return this;
		}

		public ContactData withGroupMember(String groupMember) {
			this.groupMember = groupMember;
			return this;
		}

		public ContactData withSecondaryAddress(String secondaryAddress) {
			this.secondaryAddress = secondaryAddress;
			return this;
		}

		public ContactData withSecondaryPhone(String secondaryPhone) {
			this.secondaryPhone = secondaryPhone;
			return this;
		}
		
		public ContactData withId(Integer contactId) {
			id = contactId;
			return this;
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
	

	public String toString(String delimeter) {
		return StringUtils.join(new String[] {firstName, lastName, mainAddress, homeTel, mobileTel, workTel, mainEmail, 
				secondaryEmail, bday, bmonth, byear, groupMember, secondaryAddress, secondaryPhone, "!\n"}, delimeter);
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
		if (homeTel == null) {
			if (other.homeTel != null)
				return false;
		} else if (!homeTel.equals(other.homeTel))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (mainEmail == null) {
			if (other.mainEmail != null)
				return false;
		} else if (!mainEmail.equals(other.mainEmail))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		//return this.id.compareTo(other.id);
		return this.lastName.toLowerCase().compareTo(other.lastName.toLowerCase());
	}
	
}