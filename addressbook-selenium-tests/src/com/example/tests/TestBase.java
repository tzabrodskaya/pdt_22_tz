package com.example.tests;

import static com.example.tests.ContactDataGenerator.generateRandomContacts;
import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.example.fw.ApplicationManager;

/**
 * Basic methods for initialization and stop the application manager for the specified browser
 * DataProvider are defined for groups and contacts
 * 
 * @version 0.9
 *
 */
public abstract class TestBase {
	
	protected static ApplicationManager app;
	private int checkCounter;
	private int checkFrequency;


	@BeforeTest
	@Parameters({"configFile"})
	public void setUp(@Optional String configFile) throws Exception {
		if (configFile == null) {
			configFile = System.getProperty("configFile", "applicationFF.properties");
		}
	
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		app = ApplicationManager.getInstance();
		app.setProperties(properties);
		app.getDriverHelper();
		
		checkCounter = 0;
		checkFrequency = Integer.parseInt(properties.getProperty("check.frequency", "0"));
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();

	  }
	 
	protected boolean wantToCheck() {
		checkCounter++;
		if (checkCounter > checkFrequency) {
			checkCounter = 0;
			return true;
		}
		return false;
	}
	
	// data provider for groups
	@DataProvider 
	public Iterator<Object[]> randomValidGroupGenerator() {
		return wrapGroupsForDataProvider(generateRandomGroups(5)).iterator();
	  }
	
	public List<Object[]> wrapGroupsForDataProvider(List<GroupData> groups) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (GroupData group: groups) {
			list.add(new Object[]{group});
		}
		return list;
	}

	// data provider for contacts
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		return wrapContactsForDataProvider(generateRandomContacts(3)).iterator();
	}

	public List<Object[]> wrapContactsForDataProvider(List<ContactData> contacts) {
		List<Object[]> list = new ArrayList<Object[]>();
		for (ContactData contact: contacts) {
			list.add(new Object[]{contact});
		}
		return list;
	}

	protected void checkGroupStates() {
		if (wantToCheck()) {
	    	if ("yes".equals(app.getProperty("check.db"))) {
	    		assertThat(app.getModel().getGroups(), equalTo(app.getHibernateHelper().listGroups()));
	    	}
	    	if ("yes".equals(app.getProperty("check.ui"))) {
	    		assertThat(app.getModel().getGroups(), equalTo(app.getGroupHelper().getUIGroups()));
	    	}
	    	if ("yes".equals(app.getProperty("check.dbToUI"))) {
	    		assertThat(app.getHibernateHelper().listGroups(), equalTo(app.getGroupHelper().getUIGroups()));
	    	}
	    }
	}
	
	protected void checkContactStates() {
		if (wantToCheck()) {
		    if ("yes".equals(app.getProperty("check.db"))) {
		    	assertThat(app.getModel().getContacts(), equalTo(app.getHibernateHelper().listContacts()));
		    }
		    if ("yes".equals(app.getProperty("check.ui"))) {
		    	assertThat(app.getModel().getContacts(), equalTo(app.getContactHelper().getUIContacts()));
		    }
		    if ("yes".equals(app.getProperty("check.dbToUI"))) {
		    	assertThat(app.getHibernateHelper().listContacts(), equalTo(app.getContactHelper().getUIContacts()));
		    }
		}
	}
	
	

}
