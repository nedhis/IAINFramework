package com.mma.utility;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;



public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excel;
	public static Logger log;
	
	 @BeforeSuite
		public void setUp()
		{
			driver = BrowserFactory.startapplication(driver, "http://35.154.128.4:1139/", "Firefox");
		}
		@AfterSuite
		public void tearDown()
		{   
			driver.findElement(By.xpath("//a[text()='LOG OUT']")).click();
			BrowserFactory.closeapplication(driver);
			
			//log.info("User logged out");
		}

	


}
