package com.mma.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MatterPage {
	WebDriver driver;

	public MatterPage(WebDriver ldriver) {

		this.driver = ldriver;
	}

	@FindBy(xpath = "//*[@id='dynamicContentContainer']/li[2]/a/i")
	WebElement mattermenu;
	@FindBy(xpath = "//a[p='Matter Listing']")
	WebElement matterlisting;
	@FindBy(xpath = "//a[@class='btn btn-primary btn-sm float-right']")
	WebElement addmatter;
	@FindBy(xpath = "//select[@id='ConflictNo']")
	WebElement conflictno;
	@FindBy(xpath = "//select[@id='CurrencyID']")
	WebElement currency;
	@FindBy(xpath = "//a[@id='Office-tab']")
	WebElement teamtab;
	@FindBy(xpath = "//select[@id='TeamLeadID']")
	WebElement teamlead;
	@FindBy(xpath = "//a[@id='Bank-tab' and @class='nav-link']")
	WebElement billinfo;
	@FindBy(xpath = "//select[@id='BillingContactId']")
	WebElement billcontactname;
	@FindBy(xpath = "//select[@id='CategoryId']")
	WebElement category;
	@FindBy(xpath = "//select[@id='FeeStructure']")
	WebElement feestructure;
	@FindBy(xpath = "//button[@id='btnMatterSubmit']")
	WebElement Save;

	public void creatematter(String conflictid, String curr, String tlead, String billconname, String catname,
			String fee) throws InterruptedException {
		mattermenu.click();
		matterlisting.click();
		addmatter.click();
		conflictno.sendKeys(conflictid);
		conflictno.sendKeys(Keys.ENTER);
		Select drpCurrency = new Select(currency);
		drpCurrency.selectByVisibleText(curr);
		Thread.sleep(5000);
		// teamtab.sendKeys(Keys.TAB);;
		teamtab.click();
		Thread.sleep(4000);
		Select drpTL = new Select(teamlead);
		drpTL.selectByVisibleText(tlead);
		/*WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.elementToBeClickable(billcontactname));*/
		billinfo.click();
		Select drpcontact = new Select(billcontactname);
		drpcontact.selectByVisibleText(billconname);
		Select drpcategory = new Select(category);
		drpcategory.selectByVisibleText(catname);
		Select drpfee = new Select(feestructure);
		drpfee.selectByVisibleText(fee);
		Save.click();

	}

}
