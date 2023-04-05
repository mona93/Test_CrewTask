package com.stcplans.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import webelements.components.Button;
import webelements.components.ButtonImpl;
import webelements.components.Element;



public class STCPage {

	WebDriver driver;
	
	private static final Logger log = LogManager.getLogger(STCPage.class);
	
	@FindBy(id = "country")
	private Button chooseCountryButton;
	@FindBy(xpath = ".//label//span")
	private List<WebElement> reportsList;
	@FindBy(xpath ="//h2[text()='Choose Your Plan']")
	WebElement pageTitle;
	
	public STCPage(WebDriver driver) {
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	
    public void isLoaded() throws Error {
		try {
			Assert.assertTrue(pageTitle.isDisplayed());
		} catch (NoSuchElementException e) {
			throw new AssertionError();
		}
	}

public void clickCountryButton() {
	chooseCountryButton.click();
}

public void chooseCountry(String countryName) {
	clickCountryButton();
	Button selectedCountry= new ButtonImpl(driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[text()='" + countryName + "']")));
	selectedCountry.click();
}

public List<String> getPlansList() {
	List<String> planNames = new ArrayList<String>();
	List<WebElement> planElements = driver.findElements(By.xpath("//div[@class='plan-names']//*[contains(@id, 'name')]"));
	for (WebElement planElement : planElements) {
		planNames.add(planElement.getText());
	}
	return planNames;
}

public HashMap<String, String> getPlansPrices() {
    HashMap<String, String> priceMap = new HashMap<>();
	List<String> planPrices = new ArrayList<String>();
	List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class=plan-names']//*[contains(@class, 'price')]//b"));
	for (WebElement priceElement : priceElements) {
		planPrices.add(priceElement.getText());
	}
	priceMap.put("Lite", planPrices.get(0));
	priceMap.put("Classic",planPrices.get(1));
	priceMap.put("Premium", planPrices.get(2));
	return priceMap;
}

public HashMap<String, String> getPlansCurrency() {
    HashMap<String, String> currencyMap = new HashMap<>();
	List<String> planCurrency = new ArrayList<String>();
	List<WebElement> priceElements = driver.findElements(By.xpath("//div[@class=plan-names']//*[contains(@id, 'currency')]//i"));
	for (WebElement priceElement : priceElements) {
		planCurrency.add(priceElement.getText());
	}
	currencyMap.put("Lite", planCurrency.get(0));
	currencyMap.put("Classic",planCurrency.get(1));
	currencyMap.put("Premium", planCurrency.get(2));
	return currencyMap;
}


}

