package com.gvk.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.gvk.actions.Action;



public class Conformationpage5 extends Action {

	WebDriver driver;
	
	public Conformationpage5(WebDriver driver)
	{
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement conformationmsg;
	
	public String getconformationmsg() 
	{
		return conformationmsg.getText();
	}
}
