package com.example.fw;

import java.util.Properties;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;

/**
 * Manager class for manipulation with test application
 * 
 * @version 0.1
 *
 */
public class ApplicationManager {
	
	private static ApplicationManager singleton;
	private FolderHelper folderHelper;
	private Properties props;
	private JFrameOperator mainFrame;
	private MenuHelper menuHelper;
		
	public static ApplicationManager getInstance() {
		
		if (singleton == null) {
			singleton = new ApplicationManager();
		}
		return singleton;
	}
	
	public void setProperties(Properties props) {
		this.props = props;
	}
	
	public String getProperty(String key) {
		return props.getProperty(key);
	}
	
	public int getIntProperty(String key) {
		return Integer.parseInt(getProperty(key));
	}
	
	public void stop() {	
		getApplication().requestClose();
	}

	public FolderHelper getFolderHelper() {
		if (folderHelper == null) {
			folderHelper = new FolderHelper(this);
		}
		return folderHelper;
	}
	
	public MenuHelper getMenuHelper() {
		if (menuHelper == null) {
			menuHelper = new MenuHelper(this);
		}
		return menuHelper;
	}

	public JFrameOperator getApplication() {
		if (mainFrame == null) {
			try {
				new ClassReference("addressbook.AddressBookFrame").startApplication();
				mainFrame = new JFrameOperator("jAddressBook");
				} catch (Exception e) {
					e.printStackTrace();
				}
		}
		return mainFrame;
	}

	
	
	
}
