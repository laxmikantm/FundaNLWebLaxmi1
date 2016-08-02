/**
 * Author: Laxmi Somni
 */
package com.seleniumtests.pageobject;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumtests.support.Helper;


public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait myWait;
	public Logger loggerPageObjectLevel;
	public JavascriptExecutor jse;


	public BasePage() {

		loggerPageObjectLevel = Logger.getLogger(this.getClass());
		Logger logger = Logger.getLogger("<ClassName>");
		PropertyConfigurator.configure("Log4j.properties");

	}


	public String getPageURL(WebDriver driver){
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		return driver.getCurrentUrl();
	}

	public void getBasePage(WebDriver driver){
		driver.manage().window().maximize();
		driver.get(Helper.BaseURL);


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