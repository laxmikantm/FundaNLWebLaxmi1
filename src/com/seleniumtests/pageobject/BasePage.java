/**
 * Author: Laxmi Somni
 */
package com.seleniumtests.pageobject;
import java.util.concurrent.TimeUnit;






import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.seleniumtests.support.Helper;


public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait myWait;
//	protected SoftAssert softAssert; 
//	protected Assertion hardAssert;
	public Logger loggerPageObjectLevel;
	public JavascriptExecutor jse;
	

	public BasePage() {
//		hardAssert = new Assertion();
//		softAssert = new SoftAssert();
		
		loggerPageObjectLevel = Logger.getLogger(this.getClass());
		Logger logger = Logger.getLogger("<ClassName>");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	public String getPageURL(WebDriver driver){
		 driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		return driver.getCurrentUrl();
	}
	
	public void getBasePage(){
		driver.get(Helper.BaseURL);
		driver.manage().window().maximize();
		driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL,Keys.SUBTRACT);
	}

	public String getPageTitle(WebDriver driver) {
		return driver
					.getTitle()
							.toString();
		 
	}
	
	public WebDriver getWebDriver(){
		return driver;
	}

}