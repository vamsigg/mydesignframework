package com.gvk.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.gvk.actions.Action;



public class ProductCatalogue2 extends Action {

	WebDriver driver;
	
	public ProductCatalogue2(WebDriver driver)
	{
		super(driver);
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By productsby=By.cssSelector(".mb-3");
	
	@FindBy(css=".mb-3")
	List<WebElement> productslist;
	
	By addtocaart=By.cssSelector(".card-body button:last-of-type");
	
	By toastmesg=By.cssSelector("#toast-container");
	
	@FindBy(css=".ng-animating")
	WebElement spinner;
	
	@FindBy(css="button[routerlink*='/cart']")
	WebElement cartHeader;
	
	public List<WebElement> getproductlist()
	{
		waitforelementtoappear(productsby);
		return productslist;
	}
	
	public WebElement getproductbyname(String productname)
	{
		WebElement prod= getproductlist().stream().filter(s->s.findElement(By.cssSelector("b"))
				        .getText().equals(productname)).findFirst().orElse(null);      
        return prod;
	}
	
	public void addproducttocart(String productname)
	{
		WebElement prodtocart=getproductbyname(productname);
		prodtocart.findElement(addtocaart).click();
		waitforelementtoappear(toastmesg);
		waitforelementtodisappear(spinner);
	}
	
	public void gotocartpage()
	{
		cartHeader.click();
	}
}
