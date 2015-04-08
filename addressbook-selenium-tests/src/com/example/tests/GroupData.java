package com.example.tests;

import org.apache.commons.lang3.StringUtils;

/**
 *  Data for filling Group form with overridden basic methods
 *
 * @version 0.4
 */
public class GroupData implements Comparable<GroupData>{
	private String name;
	private String header;
	private String footer;

	public GroupData(String name, String header, String footer) {
		this.name = name;
		this.header = header;
		this.footer = footer;
	}
	
	public GroupData() {
	}
	
	public String getName() {
		return name;
	}

	public String getHeader() {
		return header;
	}

	public String getFooter() {
		return footer;
	}

	//parameters initialization
	public GroupData withName(String name) {
		this.name = name;
		return this;
	}

	public GroupData withHeader(String header) {
		this.header = header;
		return this;
	}

	public GroupData withFooter(String footer) {
		this.footer = footer;
		return this;
	}

	//Overridden basic methods, needed for compare, order and display
	@Override
	public String toString() {
		return "GroupData [name=" + name + ", header=" + header + ", footer="
				+ footer + "]";
	}
	
	public String toString(String delimeter){
		return StringUtils.join(new String[] {name, header, footer, "!\n"}, delimeter);
	}
	
	@Override
	public int hashCode() {
		//final int prime = 31;
		int result = 1;
		//result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		GroupData other = (GroupData) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public int compareTo(GroupData other) {
		return this.name.toLowerCase().compareTo(other.name.toLowerCase());
	}
	
	
}