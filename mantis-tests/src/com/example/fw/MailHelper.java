package com.example.fw;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

/**
 * Helper to manipulate e-mails
 * 
 * @version 0.1
 *
 */
public class MailHelper extends HelperBase {

	private String mailserver;
	
	public MailHelper(ApplicationManager manager) {
		super(manager);
		this.mailserver = manager.getProperty("mailserver.host");
	}

	public Msg getNewMail(String user, String password) {
		Properties props = System.getProperties();
		Session session = Session.getDefaultInstance(props);
		
		Store store;
		try {
			store = session.getStore("pop3");
			store.connect(mailserver, user, password);
			Folder folder = store.getDefaultFolder().getFolder("INBOX");
			folder.open(Folder.READ_WRITE);
			if (folder.getMessageCount() != 1) {
				return null;
			}
			Message message = folder.getMessage(1);
			
			message.setFlag(Flags.Flag.DELETED, true);
			Msg msg = new Msg((String) message.getContent());
			folder.close(true);
			store.close();

			return msg;
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
