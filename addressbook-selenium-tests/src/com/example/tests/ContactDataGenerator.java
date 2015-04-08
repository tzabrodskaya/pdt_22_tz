package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import com.thoughtworks.xstream.XStream;

/**
 * Data Generator for Contacts 
 *  
 * @param amount the number of parameters to generate
 * @param file the file name to store generated data
 * @param format of the generated data: XML or csv
 * 
 * @version 0.1
 * 
 */

public class ContactDataGenerator extends DataGeneratorBase{

	public static void main(String[] args) throws IOException {
			if (args.length < 3) {
				System.out.println("Please, specify parameters: <amount of test data> <file> <format>");
				return;
			}
			
			int amount = Integer.parseInt(args[0]);
			File file = new File(args[1]);
			String format = args[2];
			
			if (file.exists()) {
				System.out.println("File exists, please remove it manually: " + file);
				return;
			}
			
			List<ContactData> contacts = generateRandomContacts(amount);
			
			if ("csv".equals(format)) {
				saveContactsToCsvFile(contacts, file);
			} else if ("xml".equals(format)) {
				saveContactsToXMLFile(contacts, file);
			} else {
				System.out.println("Unknown format " + format + ". Please provide \"csv\" or \"xml\". ");
				return;
			}
	}

	private static void saveContactsToXMLFile(List<ContactData> contacts, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("contact",ContactData.class);
		String xml = xstream.toXML(contacts);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromXMLFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("contact",ContactData.class);
		return (List<ContactData>) xstream.fromXML(file);
	}
	
	private static void saveContactsToCsvFile(List<ContactData> contacts, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (ContactData contact: contacts) {
			writer.write(contact.toString(";"));
		}
		writer.close();
	}
	
	public static List<ContactData> loadContactsFromCsvFile(File file) throws IOException {
			List<ContactData> list = new ArrayList<ContactData>();
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line = bufferedReader.readLine();
			
			while (line !=null) {
				String[] parts = line.split(";");
				ContactData contact = new ContactData()
										.withFirstName(parts[0])
										.withLastName(parts[1])
										.withMainAddress(generateRandomString(parts[2]))
										.withHomeTel(parts[3])
										.withMobilTel(parts[4])
										.withWorkTel(parts[5])
										.withMainEmail(parts[6])
										.withSecondaryEmail(parts[7])
										.withBday(parts[8])
										.withBmonth(parts[9])
										.withByear(parts[10])
										.withGroupMember(parts[11])
										.withSecondaryAddress(parts[12])
										.withSecondaryPhone(parts[13]);
				list.add(contact);
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			return list;
	}

	public static List<ContactData> generateRandomContacts(int amount) {
		List<ContactData> list = new ArrayList<ContactData>();
		
		DateFormat df = new SimpleDateFormat("yyyyMMMM d", Locale.ENGLISH);
		String formattedDate;
		String bday;
		String bmonth;
		String byear;
		
		for (int i = 0; i < amount; i++) {
			
			Date generatedData = DataGeneratorBase.generateDate(new GregorianCalendar(1940,1,1), new GregorianCalendar(2000,1,1));
			formattedDate = df.format(generatedData);
			bday = formattedDate.replaceAll("\\d+\\w+ ","");
			bmonth = formattedDate.replaceAll("[^a-zA-Z]","");
			byear = formattedDate.substring(0, 4);
			
			ContactData contact = new ContactData()
			.withFirstName(generateRandomString("FirstName"))
			.withLastName(generateRandomString("LastName"))
			.withMainAddress(generateRandomString("Address"))
			.withHomeTel("66" + generateRandomString(""))
			.withMobilTel(generateRandomString(""))
			.withWorkTel(generateRandomString(""))
			.withMainEmail("main" + generateRandomString("e-mail@gmail.com"))
			.withSecondaryEmail(generateRandomString("e-mail2@gmail.com"))
			.withBday(bday)
			.withBmonth(bmonth)
			.withByear(byear)
			.withGroupMember("")
			.withSecondaryAddress(generateRandomString("Secondary address"))
			.withSecondaryPhone(generateRandomString("5467789898"));
		    
		    list.add(contact);
		}
		
		return list;
	}

}

