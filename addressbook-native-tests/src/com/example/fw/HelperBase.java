package com.example.fw;


/**
 * Base Helper 
 *  - to link the ApplicationManager to helpers
 *  - to manipulate the base elements in forms
 * @version 0.1
 *
 */
public abstract class HelperBase {
	
	protected final ApplicationManager manager;
	
	public HelperBase(ApplicationManager manager) {
		this.manager = manager;
	}
	

}

