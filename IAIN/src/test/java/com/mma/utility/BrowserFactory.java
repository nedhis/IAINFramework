package com.mma.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BrowserFactory {

	public static WebDriver startapplication(WebDriver driver, String appURL, String browserName)
	{   
	if(browserName.equals("Firefox"))
	{  
		System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
		driver=new FirefoxDriver();
		
	}
	else if(browserName.equals("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
		driver=new ChromeDriver();	
	}
	else if(browserName.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver", "./Drivers/internetexploredriver.exe");
		driver=new InternetExplorerDriver();
	}
	else
	{
		System.out.println("No such Browser found");
	}

	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get(appURL);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
	return driver;
	}
	
	public static void closeapplication(WebDriver driver)//passing driver so that it knows to close the current brwser.
	{
		driver.quit();
	}
}
