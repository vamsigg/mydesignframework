/**
 * 
 */
package com.gvk.Dataprovider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.gvk.Utilities.XLUtility;
import com.gvk.Dataprovider.DataProviders;



/**
 * @author Hitendra
 *
 */
public class DataProviders {

	@DataProvider(name="getdata")
	public String[][] getData() throws IOException
	{
		String path=".//Testdata//datasheet.xlsx";
		
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");	
		int totalcols=xlutil.getCellCount("Sheet1",1);
				
		String logindata[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)     //1
		{		
			for(int j=0;j<totalcols;j++)  //0
			{
				logindata[i-1][j]= xlutil.getCellData("Sheet1",i,j);  //1,0
			}
		}		
	    return logindata;				
	}
	
}
