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
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmationPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummary;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * @author Naveen Kurella
 *
 */
public class EndToEndTest  extends BaseClass{
	IndexPage indexPage;
	LoginPage loginPage;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummary orderSummary;
	OrderConfirmationPage orderConfirmationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups= {"Regression","Sanity","Smoke"})
	public void setup(String browser) {
		launhcApp(browser);
	}
	
	@AfterMethod(groups= {"Regression","Sanity","Smoke"})
	public void tearDown() {
		getDriver().quit();
	}
	
	@Test(groups="Regression")
	public void endToEndTest() throws Throwable {
		indexPage=new IndexPage();
		searchResultPage =	indexPage.searchProduct("t-shirt");
		addToCartPage =searchResultPage.clickOnProduct();
		addToCartPage.enterQuantity("5");
		addToCartPage.selectSize("M");
		addToCartPage.clickOnAddToCart();
		orderPage=addToCartPage.clickOnCheckOut();
		loginPage=orderPage.clickOnCheckOut();
		addressPage=loginPage.login1(prop.getProperty("username"), prop.getProperty("password"));
		shippingPage=addressPage.clickOnCheckOut();
		shippingPage.checkTheTerms();
		paymentPage=shippingPage.clickOnProceedToCheckOut();
		orderSummary=paymentPage.clickOnPaymentMethod();
		orderConfirmationPage=orderSummary.clickOnconfirmOrderBtn();
		String actResult=orderConfirmationPage.validateConfirmMessage();
		Assert.assertEquals(actResult, "Your order on My Store is complete.");
	}

}
