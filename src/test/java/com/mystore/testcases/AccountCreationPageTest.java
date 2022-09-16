/**
 * 
 */
package com.mystore.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * @author Naveen Kurella
 *
 */
public class AccountCreationPageTest extends BaseClass {
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accounCreationPage;

	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Sanity","Smoke"})
	public void setup(String browser) {
		launhcApp(browser);
	}
	
	@AfterMethod(groups= {"Regression","Sanity","Smoke"})
	public void tearDown() {
		
		
		getDriver().quit();
	}
	
	@Test(groups="Sanity")
	public void verifyCreateAccountPageTest() throws Throwable {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accounCreationPage=loginPage.createNewAccount("ahkhds@gmail.com");
		boolean result=accounCreationPage.validateAcountCreatePage();
		Assert.assertTrue(result);
		
	}
	
}
