package com.example.tests;

import org.testng.annotations.Test;

import com.example.fw.Folders;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

/**
 * Testing Folders Removal functionality
 * 
 * @version 0.1
 */

public class FolderRemovalTests extends TestBase {
	
	@Test
	public void testSomeFolderDeletion() {
		
		Folders oldFolders = app.getFolderHelper().getFolders();
		int folderToDelete = app.getFolderHelper().chooseRandomFolder(oldFolders);
		app.getFolderHelper().deleteFolder(folderToDelete);
		Folders newFolders = app.getFolderHelper().getFolders();
		assertThat(newFolders, equalTo(oldFolders.without(folderToDelete)));
		
	}

}
