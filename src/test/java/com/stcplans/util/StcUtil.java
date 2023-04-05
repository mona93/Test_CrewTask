package com.stcplans.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.stcplans.pages.STCPage;


public class StcUtil {

	private final WebDriver driver;	
	com.stcplans.pages.STCPage stc;
	
    public StcUtil(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public boolean checkPlanType() {
    	stc.isLoaded();
        List<String> list = Arrays.asList("Lite", "Classic","Premium");
        try {
            Assert.assertEquals(stc.getPlansList(), list);
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }
   
    public boolean checkPrices(String countryName) {
    	stc.isLoaded();
        HashMap<String, String> priceList = new HashMap<>();
    	if (countryName == "KSA") {
    		priceList.put("Lite", "15");
    		priceList.put("Classic","25");
    		priceList.put("Premium", "60");
    	} else if(countryName =="Bahrain"){
    		priceList.put("Lite", "2");
    		priceList.put("Classic","3");
    		priceList.put("Premium", "6");
    	} else if(countryName =="Kuwait"){
    		priceList.put("Lite", "1.2");
    		priceList.put("Classic","2.5");
    		priceList.put("Premium", "4.8");
    	}
        try {
            Assert.assertTrue(stc.getPlansPrices().equals(priceList);
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }

	public boolean checkCurrency(String countryName) {
    	stc.isLoaded();
        HashMap<String, String> countryList = new HashMap<>();
    	if (countryName == "KSA") {
    		countryList.put("Lite", "SAR/month");
    		countryList.put("Classic","SAR/month");
    		countryList.put("Premium", "SAR/month");
    	} else if(countryName =="Bahrain"){
    		countryList.put("Lite", "BHD/month");
    		countryList.put("Classic","BHD/month");
    		countryList.put("Premium", "BHD/month");
    	} else if(countryName =="Kuwait"){
    		countryList.put("Lite", "KWD/month");
    		countryList.put("Classic","KWD/month");
    		countryList.put("Premium", "KWD/month");
    	}
        try {
            Assert.assertTrue(stc.getPlansCurrency().equals(countryList));
            return true;
        } catch (AssertionError e) {
            return false;
        }
    }
    
    
    public void chooseCountry(String countryName) {
    	stc.clickCountryButton();
    	stc.chooseCountry(countryName);
    	stc.isLoaded();
    }
    
    public void takeScreenShot(String fileName) {
    		TakesScreenshot scrShot =((TakesScreenshot)driver);
            File SrcFile=scrShot.getScreenshotAs(fileName.FILE);
            File DestFile=new File("/TestCrew_Task/testData/fileName.FILE");
            FileHandler.copy(SrcFile, DestFile);
    
}
}