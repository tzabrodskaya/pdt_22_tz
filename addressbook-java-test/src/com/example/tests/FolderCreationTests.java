package com.example.tests;


import org.testng.annotations.Test;

import com.example.fw.Folders;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Testing Folders Creation functionality
 * 
 * @version 0.1
 */

public class FolderCreationTests extends TestBase {

	@Test
	public void testFolderCreation() {
		String folder = generateNotEmptyRandomString("newFolder");
		Folders oldFolders = app.getFolderHelper().getFolders();
		app.getFolderHelper().createFolder(folder);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));		
	}
	
	@Test
	public void testVariousFolderCreation() {
		String folder1 = generateNotEmptyRandomString("newFolder");
		String folder2 = generateNotEmptyRandomString("newFolder");
		Folders oldFolders = app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder1), is(nullValue()));
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder1)));	
		
		assertThat(app.getFolderHelper().createFolder(folder2), is(nullValue()));
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders.withAdded(folder2)));	
	}
	
	@Test
	public void testFoldersWithSameNameCreation() {
		String folder = generateNotEmptyRandomString("newFolder");
		
		Folders oldFolders = app.getFolderHelper().getFolders();
		assertThat(app.getFolderHelper().createFolder(folder), is(nullValue()));
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.withAdded(folder)));	
		
		assertThat(app.getFolderHelper().createFolder(folder), containsString("Duplicated folder name"));
		
		Folders newFolders2 = app.getFolderHelper().getFolders();
		assertThat(newFolders2, equalTo(newFolders));	
	}
}
