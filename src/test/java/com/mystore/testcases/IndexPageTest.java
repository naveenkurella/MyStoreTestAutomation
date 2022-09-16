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
import com.mystore.pageobjects.IndexPage;

/**
 * @author Naveen Kurella
 *
 */
public class IndexPageTest extends BaseClass {
	
	IndexPage indexPage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Sanity","Smoke"})
	public void setup(String browser) {
		launhcApp(browser);
	}
	
	@AfterMethod(groups= {"Regression","Sanity","Smoke"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups="Smoke")
	public void verifyLog() throws InterruptedException {
		indexPage=new IndexPage();
	boolean result=	indexPage.validateLogo();
	Assert.assertTrue(result);
		
	}
	
	@Test(groups="Smoke")
	public void verifyTitle() {
		
		String actTitle=indexPage.getMyStoreTitl();
		Assert.assertEquals(actTitle, "My Store");
	}
	
	@Test(groups="Smoke")
	public void verifyTest() {
		
		String actTitle=indexPage.getMyStoreTitl();
		Assert.assertEquals(actTitle, "My Store2");
	}
	
}
