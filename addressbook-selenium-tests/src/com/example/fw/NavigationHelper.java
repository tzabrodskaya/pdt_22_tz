package com.example.fw;

import org.openqa.selenium.By;

/**
 * Helper to navigate through the pages
 * @author tzabrodskaya
 * @version 0.1
 *
 */
public class NavigationHelper extends HelperBase{
	
	public NavigationHelper(ApplicationManager manager) {
		super(manager);
	}

	public void openMainPage() {
	    driver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}

	public void gotoGroupsPage() {
		click(By.linkText("groups"));
	}

}
