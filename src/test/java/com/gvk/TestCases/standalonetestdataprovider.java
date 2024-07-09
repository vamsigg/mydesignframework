package com.gvk.TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gvk.Dataprovider.DataProviders;
import com.gvk.PageObjects.Cartpage3;
import com.gvk.PageObjects.Checkoutpage4;
import com.gvk.PageObjects.Conformationpage5;
import com.gvk.PageObjects.Landingpage1;
import com.gvk.PageObjects.Orderspage;
import com.gvk.PageObjects.ProductCatalogue2;
import com.gvk.TestBase.BaseClass;
import com.gvk.Utilities.XLUtility;

public class standalonetestdataprovider extends BaseClass{

	@Test
	public void standalone() throws IOException, InterruptedException
	{
        String productname="IPHONE 13 PRO";
		
		Landingpage1 landingpage=new Landingpage1(driver);
		landingpage.loginapplication("iqa@gmail.com","738218@Ggvk");
	
		ProductCatalogue2 productcatalogue=new ProductCatalogue2(driver);	
		productcatalogue.getproductlist();
		productcatalogue.addproducttocart(productname);
		Thread.sleep(1000);
		productcatalogue.gotocartpage();
		
		Cartpage3 cartpage=new Cartpage3(driver);
		Boolean match=cartpage.verifyproductdisplay(productname);
		Assert.assertTrue(match);
		cartpage.gotocheckout(); 
		
		Checkoutpage4 checkoutpage=new Checkoutpage4(driver);
		checkoutpage.selectcountry("india");
		checkoutpage.submitorder();
		
		Conformationpage5 conformationpage=new Conformationpage5(driver);
		String conformmessage=conformationpage.getconformationmsg();
	    Assert.assertTrue(conformmessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	}
	
	@Test(dataProvider="getdata",dataProviderClass = DataProviders.class,dependsOnMethods= {"standalone"})
	public void orderhistory(String email,String password,String product)
	{
		//to verify iphone 13 pro is displaying in the order page
		//Landingpage1 landingpage=new Landingpage1(driver);
		landingpage.loginapplication(email,password);
		Orderspage orderspage=new Orderspage(driver);
		orderspage.gotoorderspage();
		Assert.assertTrue(orderspage.verifyorderdisplay(product));
	}

/*	@DataProvider
	public String[][] getData() throws IOException
	{
		String path=".\\src\\test\\java\\Automation\\Data\\datasheet.xlsx";
		
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)     //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
			}
		}		
	    return logindata;				
	}
	
  /*  @DataProvider
	public Object[][] getdata()
	{
		return new Object[][]  {{"iqa@gmail.com","738218@Ggvk","IPHONE 13 PRO"},{"iqa@gmail.com","738218@Ggvk","IPHONE 13 PRO"}};
	}*/
	
	
  //if we have more parameters will go for hashmap
  /*@Test(dataProvider="getdata",dependsOnMethods= {"standalone"})
	public void orderhistory(HashMap<String,String> input)
	{
		//to verify zara coat 3 is displaying in the order page
		//Landingpage1 landingpage=new Landingpage1(driver);
		landingpage.loginapplication(input.get("email"), input.get("password"));
		Orderspage orderspage=new Orderspage(driver);
		orderspage.gotoorderspage();
		Assert.assertTrue(orderspage.verifyorderdisplay(input.get("product")));
	}
    @DataProvider
	public Object[][] getdata() throws IOException
	{
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("email", "iqa@gmail.com");
		map.put("password", "738218@Ggvk");
		map.put("product", "IPHONE 13 PRO");
		
		HashMap<String,String> map1=new HashMap<String,String>();
		map1.put("email","iqa@gmail.com");
		map1.put("password","738218@Ggvk");
		map1.put("product","IPHONE 13 PRO");
			
		return new Object[][]  {{map},{map1}};
	}*/
    
	
    //this hashmaps will automatically create by scaning json	
	/*	@Test(dataProvider="getdata",dependsOnMethods= {"standalone"})
	public void orderhistory(HashMap<String,String> input)
	{
	//to verify iphone 13 pro is displaying in the order page
	//Landingpage1 landingpage=new Landingpage1(driver);	
	landingpage.loginapplication("iqa@gmail.com","738218@Ggvk");
	Orderspage orderspage=new Orderspage(driver);
	orderspage.gotoorderspage();
	Assert.assertTrue(orderspage.verifyorderdisplay(input.get("product")));
	}
    @DataProvider
	public Object[][] getdata() throws IOException
	{
        List<HashMap<String,String>> data=getjsondatatomap(System.getProperty("user.dir")+"\\src\\test\\java\\Automation\\Data\\orderdata.json");
        return new Object[][]  {{data.get(0)},{data.get(1)}};
        
        //Object[][]  yu={{data.get(0)},{data.get(1)}};
        //return yu;
	}*/
}

