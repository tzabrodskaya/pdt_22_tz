package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.example.fw.ApplicationManager;
import com.example.fw.JdbcHelper;

/**
 * Sample
 * 
 *  - to check different approaches: JdbcHelper and HibernateHelper
 * 
 **/
public class Sample {

	public static void main(String[] args) throws IOException {
		String configFile = System.getProperty("configFile","applicationFF.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File(configFile)));
		ApplicationManager app  = ApplicationManager.getInstance();
		app.setProperties(properties);
		System.out.println(app.getHibernateHelper().listGroups());
		System.out.println(app.getHibernateHelper().listContacts());
		JdbcHelper jdbc = new JdbcHelper(app,"jdbc:mysql://localhost/addressbook?user=root&password=");
		System.out.println(jdbc.listGroups());
	}
}
