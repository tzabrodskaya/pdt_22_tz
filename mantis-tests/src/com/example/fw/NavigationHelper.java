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
	
	public void loginPage() {
		if(! onLoginPage()) {
			openUrl("");
		}
	}

	private boolean onLoginPage() {
		return driver.getCurrentUrl().contains("login_page.php");
	}
	
	public void signUpPage() {
		if(! onSignUpPage()) {
			loginPage();
			//click(By.xpath("//a[@href='signup_page.php']"));
			click(By.cssSelector(".bracket-link>a"));
		}
	}

	private boolean onSignUpPage() {
		return (findElements(By.xpath("//*[@value='Signup']")).size() > 0);
	}
	
	public void openUrl(String url) {
		driver.get(manager.getProperty("baseUrl") + url);
	}

	public void openAbsoluteUrl(String absoluteURL) {
		driver.get(absoluteURL);
	}
	

}
