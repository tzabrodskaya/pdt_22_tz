package com.example.fw;

import org.netbeans.jemmy.operators.JMenuBarOperator;

/**
 * Helper to manipulate the Main menu
 * @version 0.1
 *
 */

public class MenuHelper extends HelperBase{
	private JMenuBarOperator menu;
	
	public MenuHelper(ApplicationManager manager) {
		super(manager);
		menu = new JMenuBarOperator(mainFrame);
	}
	
	public void pushCreateFolder() {		
		menu.pushMenuNoBlock("File|New folder...");
	}

	public void pushRemoveFolder() {
		menu.pushMenuNoBlock("File|Delete");
		
	}
}
