package com.example.fw;

import java.io.IOException;


/**
 * Helper to start the test application
 * @version 0.1
 *
 */
public class ProcessHelper extends HelperBase{
 
	//Process process;

	public ProcessHelper(ApplicationManager manager) {
		super(manager);
	}

	public void startAppUnderTest() throws IOException {
		String command = manager.getProperty("app.path");
		//process =
		Runtime.getRuntime().exec(command);
	}
	
	public void stopAppUnderTest() {
		//process.destroy();
		manager.getAutoItHelper()
			.winWaitAndActivate("AddressBook Portable", "", 5000)
			.click("TRbButton9");
	}
}
