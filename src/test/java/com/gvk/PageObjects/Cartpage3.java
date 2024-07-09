package com.gvk.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.gvk.actions.Action;


public class Cartpage3 extends Action {

	WebDriver driver;
	
	public Cartpage3(WebDriver driver)
	{
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> carproducts;
	
	@FindBy(css="li[class='totalRow'] button[type='button']")
	WebElement checkoutele;
	
	public Boolean verifyproductdisplay(String Productname)
	{
		Boolean match=carproducts.stream().anyMatch(cartproduct->cartproduct.getText().equalsIgnoreCase(Productname));
		return match;
	}
	
	public void gotocheckout()
	{
		checkoutele.click();
	}
}
