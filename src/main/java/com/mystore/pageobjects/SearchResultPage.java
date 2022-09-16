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
public class SearchResultPage extends BaseClass {
	
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]//img")
	private WebElement productResult;

	
	public SearchResultPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	
	public boolean isProductAvailiable() throws Throwable {
		
		return Action.isDisplayed(getDriver(), productResult);
			
	}
	
	public AddToCartPage clickOnProduct() throws Throwable  {
		
		Action.click(getDriver(), productResult);
		return new AddToCartPage();
		
	}
}
