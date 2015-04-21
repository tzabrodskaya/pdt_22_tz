package com.example.fw;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * WebDriverHelperBase
 *  - to link the ApplicationManager to Web-helpers
 *  - to manipulate the base elements in forms
 *  
 * @version 0.1
 *
 */
public abstract class WebDriverHelperBase extends HelperBase{
	
	private boolean acceptNextAlert = true;
	protected WebDriver driver;
	
	
	public WebDriverHelperBase(ApplicationManager manager) {
		super(manager);
		this.driver = manager.appDriver;
	}
	
	//base methods to manipulate the text fields, drop-down list, buttons
	protected WebElement findElement(By by) {
		try {
			return driver.findElement(by);
		}catch (Exception e) {
			return null;
		}
	}

	protected List<WebElement> findElements(By by) {
			return driver.findElements(by);    	
    }
	
	public void type(By locator, String text) {
		if (text != null || text != "") {
			findElement(locator).clear();
			findElement(locator).sendKeys(text);
		}
	}

	protected void click(By locator) {
		findElement(locator).click();
	}
	
	protected void selectByText(By locator, String text) {
		if (text !=null) {
			new Select(findElement(locator)).selectByVisibleText(text);
		}
	}
	
	protected String getValueByName(String name) {
		return findElement(By.name(name)).getAttribute("value");
	}
	//auxiliary methods
		public boolean isElementPresent(By by) {
		    try {
		     findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
		  }

		
		public boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
		  }

		public String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
		  }

}
