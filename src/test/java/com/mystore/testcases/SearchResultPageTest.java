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
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author Naveen Kurella
 *
 */
public class SearchResultPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Sanity","Smoke","Regression"})
	public void setup(String browser) {
		launhcApp(browser);
	}
	
	@AfterMethod(groups= {"Sanity","Smoke","Regression"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Smoke")
	public void productAvailability() throws Throwable {
		
		indexPage=new IndexPage();
	searchResultPage =	indexPage.searchProduct("t-shirt");
	boolean result=searchResultPage.isProductAvailiable();
	Assert.assertTrue(result);

}
	
}
