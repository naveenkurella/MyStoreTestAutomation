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
public class AddToCartPage extends BaseClass {

	
	public AddToCartPage() {
		PageFactory.initElements(getDriver(), this);
	}
	
	@FindBy(id="quantity_wanted")
	WebElement quantityWanted;
	
	@FindBy(name="group_1")
	private WebElement size;
	
	@FindBy(xpath="//span[text()='Add to cart']")
	private WebElement addToCartBtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	private WebElement addToCartMessag;
	
	@FindBy(xpath="//span[contains(text(),'Proceed to checkout')]")
	private WebElement proceedToCheckOutBtn;
	
	public void  enterQuantity(String quantity)  throws Throwable{
		Action.type(quantityWanted, quantity);
	}
	
	public void selectSize(String size1) throws Throwable{
		
		Action.selectByVisibleText(size1, size);
	}
	
	public void clickOnAddToCart() throws Throwable {
		
		Action.click(getDriver(), addToCartBtn);
	}
	
	public boolean validateAddtoCart() throws Throwable{
		Action.fluentWait(getDriver(), addToCartMessag, 10);
		return Action.isDisplayed(getDriver(), addToCartMessag);
		
	}
	
	public OrderPage clickOnCheckOut() throws Throwable {
		Action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
		Action.JSClick(getDriver(), proceedToCheckOutBtn);
		return new OrderPage();
	}
}
