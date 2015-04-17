package com.example.fw;

import org.openqa.selenium.By;

/**
 * Helper to navigate through the pages
 * 
 * @version 0.3
 *
 */
public class NavigationHelper extends WebDriverHelperBase{
	
	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void mainPage() {
		if(! onMainPage()) {
	    click(By.linkText("home"));
		}
	}

	private boolean onMainPage() {
		return (findElements(By.id("maintable")).size() > 0);
	}

	public void groupsPage() {
		if(! onGroupPage()) {
			click(By.linkText("groups"));
		}		
	}

	private boolean onGroupPage() {
		return driver.getCurrentUrl().contains("/group.php") && (findElements(By.name("new")).size() > 0);
	}
	
	public void addressBookPage() {
		if (! onAddressBookPage()) {
			click(By.linkText("print all"));
		}
	}

	private boolean onAddressBookPage() {
		return (findElements(By.name("Address book")).size() > 0) && driver.getCurrentUrl().contains("print&phones");
	}

}
