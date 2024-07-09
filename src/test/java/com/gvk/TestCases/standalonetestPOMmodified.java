package com.gvk.TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gvk.PageObjects.Cartpage3;
import com.gvk.PageObjects.Checkoutpage4;
import com.gvk.PageObjects.Conformationpage5;
import com.gvk.PageObjects.Landingpage1;
import com.gvk.PageObjects.ProductCatalogue2;
import com.gvk.TestBase.BaseClass;
import com.gvk.Utilities.XLUtility;

public class standalonetestPOMmodified extends BaseClass{

	@Test
	public void standalone() throws IOException, InterruptedException
	{
		String productname="ADIDAS ORIGINAL";
		
		Landingpage1 landingpage=new Landingpage1(driver);
		landingpage.loginapplication("iqa@gmail.com","738218@Ggvk");
		log.error("================error message==================");
		
		ProductCatalogue2 productcatalogue=new ProductCatalogue2(driver);	
		productcatalogue.getproductlist();
		productcatalogue.addproducttocart(productname);
		Thread.sleep(1000);
		productcatalogue.gotocartpage();
		log.fatal("===================fatal message================");
		
		Cartpage3 cartpage=new Cartpage3(driver);
		Boolean match1=cartpage.verifyproductdisplay(productname);
		Assert.assertTrue(match1);
		cartpage.gotocheckout();
		log.debug("======================debug message=============");
		
		Checkoutpage4 checkoutpage=new Checkoutpage4(driver);
		checkoutpage.selectcountry("india");
		checkoutpage.submitorder();
		log.info("=================info message====================");
		
		Conformationpage5 conformationpage=new Conformationpage5(driver);
		String conformmessage1=conformationpage.getconformationmsg();
	    Assert.assertTrue(conformmessage1.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	    log.trace("=================trace message==================");
	   
	    log.warn("===================warn message==================");
	}
}

