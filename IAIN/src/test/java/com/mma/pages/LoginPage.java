package com.mma.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver ldriver)// initialize the state of an object
	{
		this.driver = ldriver;
	}

	@FindBy(name = "name")
	WebElement userid;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(id = "btnSubmit")
	WebElement login;

	public void loginapp(String username, String pwd) {

		userid.sendKeys(username);
		password.sendKeys(pwd);
		login.click();
		
	}

}
