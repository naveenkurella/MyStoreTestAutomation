package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {
	
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInBtn;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement  myStorLogo;
	
	@FindBy(xpath="//input[@id='search_query_top']")
	WebElement  searchProductBox;
	
	@FindBy(name="submit_search")
	WebElement searchButton;

	
	
	public IndexPage() {
		
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public LoginPage clickOnSignIn() throws Throwable {
		
		Action.click(getDriver(), signInBtn);
		return new LoginPage();
	}
	
	public boolean validateLogo() throws InterruptedException {
		Thread.sleep(3000);
		return Action.isDisplayed(getDriver(), myStorLogo);
	}

	public String getMyStoreTitl() {
		String myStorTitle=getDriver().getTitle();
		return myStorTitle;
		
		
	}
	
	public SearchResultPage searchProduct(String productName) {
		
		Action.fluentWait(getDriver(), searchProductBox, 10);
		Action.type(searchProductBox, productName);
		Action.click(getDriver(), searchButton);
		return new SearchResultPage();
	}

}

