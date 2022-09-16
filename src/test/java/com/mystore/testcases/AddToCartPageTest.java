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
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * @author Naveen Kurella
 *
 */
public class AddToCartPageTest extends BaseClass {
	
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Sanity","Smoke"})
	public void setup(String browser) {
		launhcApp(browser);
	}
	@AfterMethod(groups= {"Regression","Sanity","Smoke"})
	public void tearDown() {
		getDriver().quit();
	}

	@Test(groups={"Regression","Sanity"})
	public void addTocCartTest() throws Throwable {
		indexPage=new IndexPage();
		searchResultPage =	indexPage.searchProduct("t-shirt");
		addToCartPage =searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("5");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		boolean result=addToCartPage.validateAddtoCart();
		Assert.assertTrue(result);
		
	}
}
