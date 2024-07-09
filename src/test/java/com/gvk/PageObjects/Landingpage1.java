package com.gvk.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.gvk.actions.Action;



public class Landingpage1 extends Action {

	WebDriver driver;
	
	public Landingpage1(WebDriver driver)  //initialization
	{
		super(driver);
		
		this.driver=driver;                                         
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="userEmail")            //Pagefactory   //WebElement useremail=driver.findElement(By.id("userEmail"));
	WebElement useremail;
	
	@FindBy(id="userPassword")
	WebElement userpassword;
	
	@FindBy(id="login")
	WebElement usersubmit;
	
	@FindBy(css="[class*='flyInOut']") //.ng-tns-c4-9.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	WebElement errormsg;
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}

	public void loginapplication(String email,String password)
	{
		useremail.sendKeys(email);
		userpassword.sendKeys(password);
		usersubmit.click();
	}	
	
	public String geterrormsg()
	{
		waitforwebelementtoappear(errormsg);
		return errormsg.getText();
	}
}
