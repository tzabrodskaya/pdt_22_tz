package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Initialization and closing the browser of defined type for ApplicationManager
 * @version 0.4
 *
 */
public class DriverHelper extends WebDriverHelperBase{
	
	private enum Browser {
		FF, CHROME, IE
	}
	
	public DriverHelper(ApplicationManager manager, String browser) {
		super(manager);
		
		switch (Browser.valueOf(browser)) {
		case FF:
			manager.appDriver = new FirefoxDriver();
			break;
		case CHROME:
			manager.appDriver = new ChromeDriver();
			break;
		case IE:
			//have to ignore security to start (probably only IE8 issue)
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
			manager.appDriver = new InternetExplorerDriver(caps);
			break;
		default:
			System.out.println("Wrong browser is defined, initializing FireFox by default..");
			manager.appDriver = new FirefoxDriver();
		}
		
		manager.appDriver.manage().timeouts().implicitlyWait(manager.getLongProperty("implicitWait"), TimeUnit.SECONDS);
		// TODO put timeout into properties file
		manager.appDriver.get(manager.baseUrl + "/addressbookv4.1.4/");
	}
	
	
	public void quit() {
		 manager.appDriver.quit();
	}

}
