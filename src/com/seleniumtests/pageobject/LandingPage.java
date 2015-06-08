package com.seleniumtests.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {
	
	private static final String LANDING_PAGE_EXPECTED_URL = "https://demo.oneflowcloud.com";

	private WebDriver driver;
	
//	@FindBy(linkText="Products")
	@FindBy(css=".icon-book")
	private WebElement productsMenuItem;
	
	@FindBy(css=".icon-shopping-cart")
	private WebElement SKUSlink;
	
	By ProductsMenu=By.cssSelector(".icon-book");
	
	By waitAnimation=By.id("spin");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory aFactory= new AjaxElementLocatorFactory(driver, 35);
		PageFactory.initElements(aFactory, this);		
		myWait = new WebDriverWait(driver, 25);	
		jse = (JavascriptExecutor)driver;
	}
	
	public boolean verifyPageURL() {
		String expectedPageURL=LANDING_PAGE_EXPECTED_URL;
		return super
				.getPageURL(driver)
						.contains(expectedPageURL);
	}
	
	
	public String getTitle(){
		return driver
					.getTitle()
							.toString();
	}
	
	public SKUSHomePage navigateToSKUS(){
		productsMenuItem.click();
		
		WebElement element = driver.findElement(ProductsMenu);
		
		Actions action = new Actions(driver);
		action.click(element).build().perform();
		SKUSlink.click();
			myWait.until(ExpectedConditions.invisibilityOfElementLocated(waitAnimation));
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		return new SKUSHomePage(driver);
		
	}
	
}
