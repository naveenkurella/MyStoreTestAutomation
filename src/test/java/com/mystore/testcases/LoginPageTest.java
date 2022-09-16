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
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;

/**
 * @author Naveen Kurella
 *
 */
public class LoginPageTest extends BaseClass {

	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Sanity","Smoke"})
	public void setup(String browser) {
		launhcApp(browser);
	}
	
	@AfterMethod(groups= {"Regression","Sanity","Smoke"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(dataProvider="credentials", dataProviderClass = DataProviders.class,groups={"Smoke","Sanity"})
	public void loginTest(String uname,String pswd) throws Throwable {
		
		Log.startTestCase("loginTest");
		Log.info("User is going to sign In");
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		Log.info("User will enter un and pw");
		//homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage=loginPage.login(uname,pswd);
		String actualURL=homePage.getCurrURL();
		String expectedURL="http://automationpractice.com/index.php?controller=my-account";
		Log.info("Verify if user able to login");
		
		Assert.assertEquals(actualURL, expectedURL);
		Log.endTestCase("loginTest");
		
	}
}
