/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Naveen Kurella
 *
 */
public class LoginPage extends BaseClass {

	@FindBy(id = "email")
	WebElement userName;

	@FindBy(name = "passwd")
	WebElement passWord;

	@FindBy(id = "SubmitLogin")
	WebElement signInBtn;

	@FindBy(name = "email_create")
	WebElement emailForNewAccount;

	@FindBy(name = "SubmitCreate")
	WebElement createNewAccountBtn;

	public LoginPage() throws Throwable {

		PageFactory.initElements(getDriver(), this);
	}

	public HomePage login(String uname, String pwd) throws Throwable {

		Action.type(userName, uname);
		Action.type(passWord, pwd);
		Action.click(getDriver(), signInBtn);
		return new HomePage();

	}
	public AddressPage login1(String uname, String pwd) throws Throwable {

		Action.type(userName, uname);
		Action.type(passWord, pwd);
		Action.click(getDriver(), signInBtn);
		return new AddressPage();

	}

	public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
		Action.type(emailForNewAccount, newEmail);
		Action.click(getDriver(), createNewAccountBtn);

		return new AccountCreationPage();
	}

}
