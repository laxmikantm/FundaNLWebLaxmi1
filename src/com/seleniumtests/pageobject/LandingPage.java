package com.seleniumtests.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {

	private static final String HOME_PAGE = "https://www.pond5.com/";

	private WebDriver driver;

	@FindBy(xpath="//input[contains(@class,'SiteSearch-input FormControl FormControl--white   js-siteSearchInput js-siteSearchInput--autocomplete ui-autocomplete-input')]")
	private WebElement searchBox;

	@FindBy(css=".SiteSearch-btn Button Button--razzleDazzleRose js-siteSearchBtn")
	private WebElement searchButton;


	public LandingPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory aFactory= new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(aFactory, this);
		myWait = new WebDriverWait(driver, 15);
		jse = (JavascriptExecutor)driver;
	}

	public boolean getPageURL() {
		String expectedPageURL=HOME_PAGE;
		return super
				.getPageURL(driver)
				.contains(expectedPageURL);
	}


	public String getTitle(){
		return driver
				.getTitle()
				.toString();
	}

	public HomePage performSearch(final String searchKeyWord) {
		searchBox.clear();
		searchBox.sendKeys(searchKeyWord+Keys.RETURN);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return new HomePage(driver);
	}

}
