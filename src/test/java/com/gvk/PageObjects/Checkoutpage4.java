package com.gvk.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.gvk.actions.Action;


public class Checkoutpage4 extends Action {

    WebDriver driver;
    
	public Checkoutpage4(WebDriver driver)
	{
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement country;
	
	By results=By.cssSelector(".ta-results");
	
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]")
	WebElement selectcountry;
	
	@FindBy(css=".btnn")
	WebElement submit;
	
	public void selectcountry(String countryname)
	{
	  //Actions a=new Actions(driver);
	  //a.sendKeys(country,countryname).build().perform();
		country.sendKeys(countryname);
		waitforelementtoappear(results);
		selectcountry.click();
	}
	
	public void submitorder()
	{
	   //WebElement e = driver.findElement(By.cssSelector(".btnn"));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click(0);", submit);    
	   //submit.click();
	 }
}
