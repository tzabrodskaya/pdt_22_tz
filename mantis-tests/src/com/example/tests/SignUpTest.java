package com.example.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

import com.example.fw.AccountHelper;
import com.example.fw.JamesHelper;
import com.example.fw.User;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class SignUpTest extends TestBase {
	
	public User user;
	private JamesHelper james;
	private AccountHelper accHelper;
	
	
	@BeforeClass	
	public void createMailUser() {
		user = readUser();
		james = app.getJamesHelper();
		accHelper = app.getAccountHelper();
		if(! james.doesUserExist(user.getLogin())) {
			james.createUser(user.getLogin(), user.getPassword());
		}
	}
	
	@Test(dataProvider = "userFromConfig")
	public void shouldSignUpNewUser(User user){
		accHelper.signUp(user);
		accHelper.login(user);
		assertThat(accHelper.loggedUser(), equalTo(user.getLogin()));
		accHelper.logout();
	}
	
	@Test(dataProvider = "userFromConfig", dependsOnMethods = "shouldSignUpNewUser")
	public void shouldNotSignUpExistingUser(User user){
		try {
		accHelper.signUp(user);
		} catch (Exception e) {
			assertThat(e.getMessage(),containsString("That username is already being used."));
			return;
		}
		
		fail("Exception expected");
	}
	
	@AfterClass	
	public void cleanUpDBandMail(){
		if (james.doesUserExist(user.getLogin())) {
			james.deleteUser(user.getLogin());
		}
		app.getHibernateHelper().deleteUser(user);
	}
	
}
