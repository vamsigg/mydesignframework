package com.gvk.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.gvk.PageObjects.Landingpage1;

public class BaseClass {

	public WebDriver driver;
	public Landingpage1 landingpage;
	public Logger log;
	
	
	public WebDriver initialisedriver() throws IOException
	{	
		Properties pro=new Properties();            //to use some outher properties we are making class variable //to get the browser information
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//Config//config.properties");
		pro.load(fis);
		
		String browsename = System.getProperty("browser")!=null ? System.getProperty("browser") : pro.getProperty("browser");//java turnery operator                                                                 
	  //String browsename = pro.getProperty("browser");
				
		if(browsename.contains("chrome"))       //for avoiding conflict with headless "chromeheadless"
		{
			ChromeOptions options = new ChromeOptions(); 
			options.addArguments("--remote-allow-origins=*");
			if(browsename.contains("headless")) //if we don't mention this, chrome also considered as headless
			{
			options.addArguments("headless");   //for running in headlessmode //for speed
			}
			driver=new ChromeDriver(options);
			driver.manage().window().setSize(new Dimension(1400,900));//full screen
	      //WebDriverManager.chromedriver().setup();
	      //driver=new ChromeDriver();
			log.debug("==============Launched chrome Browser==========================");  
		} 
		else if(browsename.equalsIgnoreCase("firefox"))
		{
			//firefoxcode
		}
		else if(browsename.equalsIgnoreCase("edge"))
		{
			//edgecode
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		return driver;
	}	
	
	@BeforeMethod(alwaysRun=true)        // we want to run this methods irrespective of the conditions
	public Landingpage1 launchapplication() throws IOException
	{	
		log=LogManager.getLogger(this.getClass());
		
		driver=initialisedriver();
	    landingpage=new Landingpage1(driver);
	    landingpage.goTo();
		return landingpage; 
	}
	
	@AfterMethod(alwaysRun=true)          // in useing grouping we require this condition
	public void teardown()
	{
		driver.close();
	}

	
}
