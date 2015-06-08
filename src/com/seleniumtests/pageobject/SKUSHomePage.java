/**
 * 
 */
package com.seleniumtests.pageobject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumtests.dataobject.SKUData;
import com.seleniumtests.support.Helper;

/**
 * @author Laxmi.Somni
 *
 */
public class SKUSHomePage extends BasePage {
	
	
	private static final String JS_SCRIPT_FOR_CLICKING_NEW_SKU_BTN = "document.getElementsByClassName(\"btn btn-blue ng-scope\")[2].click()";

	private static final String ADD_NEW_SKU_PAGE_URL = "https://demo.oneflowcloud.com/sku/add";

	private static final String SKUS_PAGE_EXPECTED_URL = "https://demo.oneflowcloud.com/sku";
	
	private WebDriver driver;
	
//	@FindBy(css="translate='order_id'")
	@FindBy(xpath="//a[contains(text(),'new_sku')][2]")
//	@FindBy(xpath="//a[@class='btn btn-blue ng-scope']")
//	@FindBy(xpath="//a[contains(@ng-hide,'hideNew || vertical')]")
	private WebElement newSkuBtn;
	
	
	public SKUSHomePage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory aFactory= new AjaxElementLocatorFactory(driver, 35);
		PageFactory.initElements(aFactory, this);		
		myWait = new WebDriverWait(driver, 25);	
		jse = (JavascriptExecutor)driver;
	}
	
	
	public boolean verifyPageURL() {
		String expectedPageURL=SKUS_PAGE_EXPECTED_URL;
		return super
				.getPageURL(driver)
					.contains(expectedPageURL);
	}
	
	public AddNewSKUPage createNewSKU(){
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);			
			jse.executeScript(JS_SCRIPT_FOR_CLICKING_NEW_SKU_BTN);
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(driver.getCurrentUrl().equalsIgnoreCase(ADD_NEW_SKU_PAGE_URL))
			return new AddNewSKUPage(driver);
		else
			return null;
	}

	
	
	
}
