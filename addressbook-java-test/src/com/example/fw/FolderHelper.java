package com.example.fw;

import java.util.ArrayList;



import java.util.Random;

import javax.swing.tree.TreePath;

import org.netbeans.jemmy.operators.JButtonOperator;
import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;

/**
 * Helper to manipulate the Folders
 * 
 * @version 0.1
 *
 */

public class FolderHelper extends HelperBase{
	
	private JTreeOperator tree;

	public FolderHelper(ApplicationManager manager) {
		super(manager);
		this.tree = new JTreeOperator(mainFrame);
	}

	public String createFolder(String folderName) {
		manager.getMenuHelper().pushCreateFolder();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JTextFieldOperator(dialog).setText(folderName);
		new JButtonOperator(dialog, "OK").push();
		return waitMessageDialog("Warning", manager.getIntProperty("timeout"));
		
	}

	public Folders getFolders() {
		ArrayList<String> list = new ArrayList<String>();
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child: children) {
			list.add("" + child);
		}
		return new Folders(list);
	}

	public void deleteFolder(int folderToDelete) {
		selectFolderById(folderToDelete);
		manager.getMenuHelper().pushRemoveFolder();
		JDialogOperator dialog = new JDialogOperator(mainFrame);
		new JButtonOperator(dialog, "Ja").push();
	}

	private void selectFolderByName(String folder) {
		int folderId = tree.findRow(folder);
		selectFolderById(folderId);
	}

	private void selectFolderById(int folderId) {
		TreePath path = tree.getPathForRow(folderId);
		tree.selectPath(path);
	}

	public int chooseRandomFolder(Folders oldFolders) {
		Random rnd = new Random();
		return  rnd.nextInt(oldFolders.size());
	}


}
