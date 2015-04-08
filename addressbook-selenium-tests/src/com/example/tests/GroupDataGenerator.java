package com.example.tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

/**
 * Data Generator for Group 
 *  
 * @param amount the number of parameters to generate
 * @param file the file name to store generated data
 * @param format of the generated data: XML or csv
 * 
 * @version 0.1
 * 
 */

public class GroupDataGenerator extends DataGeneratorBase{

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
		List<GroupData> groups = generateRandomGroups(amount);
		
		if ("csv".equals(format)) {
			saveGroupsToCsvFile(groups, file);
		} else if ("xml".equals(format)) {
			saveGroupsToXMLFile(groups, file);
		} else {
			System.out.println("Unknown format " + format + ". Please provide \"csv\" or \"xml\". ");
			return;
		}
	}

	private static void saveGroupsToXMLFile(List<GroupData> groups, File file) throws IOException {
		XStream xstream = new XStream();
		xstream.alias("group", GroupData.class);
		String xml = xstream.toXML(groups);
		FileWriter writer = new FileWriter(file);
		writer.write(xml);
		writer.close();
		
	}
	
	public static List<GroupData> loadGroupsFromXMLFile(File file) {
		XStream xstream = new XStream();
		xstream.alias("group", GroupData.class);
		return (List<GroupData>) xstream.fromXML(file);
	}

	private static void saveGroupsToCsvFile(List<GroupData> groups, File file) throws IOException {
		FileWriter writer = new FileWriter(file);
		for (GroupData group: groups) {
			writer.write(group.toString(";"));
		}
		writer.close();
	}
	
	 public static List<GroupData> loadGroupsFromCsvFile(File file) throws IOException {
			List<GroupData> list = new ArrayList<GroupData>();
			BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
			String line = bufferedReader.readLine();
			while(line != null) {
				String[] parts = line.split(";");
				GroupData group = new GroupData()
				.withName(parts[0])
				.withHeader(parts[1])
				.withFooter(parts[2]);
				list.add(group);
				line = bufferedReader.readLine();
			}			
			bufferedReader.close();
			return list;
		}

	public static List<GroupData> generateRandomGroups(int amount) {
		List<GroupData> list = new ArrayList<GroupData>();
		
		for (int i = 0; i < amount; i++) {
			  GroupData group = new GroupData()
			  		  .withName(generateRandomString("name"))
					  .withHeader(generateRandomString("header"))
					  .withFooter(generateRandomString("footer"));
			  list.add(group);
		  }
		return list;
	}
}
