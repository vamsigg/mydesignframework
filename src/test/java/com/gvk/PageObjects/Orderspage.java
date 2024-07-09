package com.gvk.PageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.gvk.actions.Action;


public class Orderspage extends Action {

    WebDriver driver;
	
	public Orderspage(WebDriver driver)
	{ 
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="button[routerlink*='myorders']")
	WebElement orderHeader;
	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> orderNames;
	
	public void gotoorderspage()
	{
		orderHeader.click();
	}
	
	public Boolean verifyorderdisplay(String Productname)
	{
		Boolean match=orderNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(Productname));
		return match;
	}
}
