package com.stcplans.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.stcplans.base.TestBase;
import com.stcplans.util.StcUtil;

public class STCPlanDemoTest extends TestBase{

	
	StcUtil stcPage;
	WebDriver driver;

	@BeforeTest
	public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\BrowserStack\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.get("https://subscribe.stctv.com/sa-en?");
	stcPage = new StcUtil(driver);
	}

	@Test(priority = 1)
	public void validateForSaudiArabia() {
	stcPage.chooseCountry("KSA");
	stcPage.checkPlanType();
	stcPage.takeScreenShot("KSA");
	Assert.assertTrue(stcPage.checkPrices("KSA"));
	Assert.assertTrue(stcPage.checkCurrency("KSA"));
	}
	
	@Test(priority = 2)
	public void validateForBahrain() {
	stcPage.chooseCountry("Bahrain");
	stcPage.checkPlanType();
	stcPage.takeScreenShot("Bahrain");
	Assert.assertTrue(stcPage.checkPrices("Bahrain"));
	Assert.assertTrue(stcPage.checkCurrency("Bahrain"));
	}

	@Test(priority = 3)
	public void validateForKuwait() {
	stcPage.chooseCountry("Kuwait");
	stcPage.checkPlanType();
	stcPage.takeScreenShot("Kuwait");
	Assert.assertTrue(stcPage.checkPrices("Kuwait"));
	Assert.assertTrue(stcPage.checkCurrency("Kuwait"));
	}
	
	
	}