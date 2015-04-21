package com.example.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AccountHelper extends WebDriverHelperBase {

	
	public AccountHelper(ApplicationManager applicationManager) {
		super(applicationManager);
	}

	public void signUp(User user){
		manager.navigateTo().signUpPage();
		fillSignUpForm(user);
		submit();
		pause(3000);
		WebElement errorMessage = findElement(By.cssSelector("table.width50>tbody>tr>td>p"));
		if(errorMessage != null) {
			throw new RuntimeException(errorMessage.getText());
		}
		
		pause(13000);
		Msg msg = manager.getMailHelper().getNewMail(user.getLogin(), user.getPassword());
		String confirmationLink = msg.getConfirmationLink();
		manager.navigateTo().openAbsoluteUrl(confirmationLink);
		
		fillConfirmForm(user);
		submit();
	}

	public void login(User user) {
		manager.navigateTo().loginPage();
		fillLoginForm(user);
		submit();
	}
	
	public String loggedUser() {
		WebElement userInfo = findElement(By.cssSelector("td.login-info-left>span"));
		return userInfo.getText();
	}

	public void logout() {
		click(By.xpath("//td[@class='menu']/a[7]"));
		
	}
//-------------------------------------------------------------

	private void fillSignUpForm(User user) {
		type(By.name("username"), user.getLogin());
		type(By.name("email"), user.getEmail());
	}

	private void fillConfirmForm(User user) {
		type(By.name("password"), user.getPassword());
		type(By.name("password_confirm"), user.getPassword());
	}

	private void fillLoginForm(User user) {
		type(By.name("username"), user.getLogin());
		type(By.name("password"), user.getPassword());
	}
	
	private void submit() {
		click(By.cssSelector("input.button"));
	}


}
