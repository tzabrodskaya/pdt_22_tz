package com.example.fw;

/**
 * Base Helper 
 *  - to link the manager with the helpers
 *  
 * @version 0.1
 *
 */

public abstract class HelperBase {
	
	protected ApplicationManager manager;

	public HelperBase(ApplicationManager manager) {
		this.manager = manager;
	}
	
	protected void pause(int pause) {
		try {
			Thread.sleep(pause);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
