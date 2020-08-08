package com.mma.testcases;



import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mma.pages.MatterPage;
import com.mma.utility.ExcelDataProvider;
//import com.mma.utility.BaseClass;
 

public class MatterTest extends LoginTest{
	//WebDriver driver;
	
	@Test(dataProvider="getMatterData")
	public void mattertest(String conflictid,String curr,String tlead,String billconname,String catname,String fee) throws InterruptedException
	{
		MatterPage matterpage=PageFactory.initElements(driver, MatterPage.class);
		matterpage.creatematter(conflictid, curr, tlead, billconname, catname, fee);
		
		Assert.assertTrue(driver.getTitle().contains("Matter - IAIN"), "Matter not added Successfully");
		System.out.println("Matter Added Successfully");
		
	}
    
	@DataProvider
	public Object[][]getMatterData()
	{
		Object data[][]=ExcelDataProvider.ExcelDataProvide("Matter");
		return data;
		
	}
}
