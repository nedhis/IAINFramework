package com.mma.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mma.pages.LoginPage;
import com.mma.utility.BaseClass;

import com.mma.utility.ExcelDataProvider;

public class LoginTest extends BaseClass {

	@Test(dataProvider = "getlogindata")
	public void loginIain(String username, String pwd) throws Exception {
		excel = new ExcelDataProvider();

		LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
		loginpage.loginapp(username, pwd);
		// loginpage.loginapp(excel.getStringData(0, 1, 0),excel.getStringData(0, 1, 1));

		Assert.assertTrue(driver.getTitle().contains("Home Page - IAIN"), "User credentials are Invalid.");
		System.out.println("Page Title verified-User logged in successfully");

		Thread.sleep(5000l);
		if (driver.getTitle().contains("Home Page - IAIN")) {

		String actual=driver.findElement(By.xpath("//button[text()='OK']")).getText();
		String expected="OK";	
		
		Assert.assertEquals(actual, expected);
		System.out.println("Time Entry is Pending");
		driver.findElement(By.xpath("//button[text()='OK']")).click();

		}

		else {

			System.out.println("No Time Entry is pending");
		}
		
			}

	@DataProvider
	public Object[][] getlogindata() {
		Object data[][] = ExcelDataProvider.ExcelDataProvide("Login");
		return data;
	}

}
