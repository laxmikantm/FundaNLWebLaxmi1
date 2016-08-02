package com.seleniumtests.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	@FindBy(xpath="//label[contains(.,'Core Library    ')]")
	private WebElement coreLibrary;

	@FindBy(xpath= "//label[contains(.,'Membership Content    ')]")
	private WebElement memContent;

	@FindBy(xpath = "//div[@class='SearchResultsV3 js-searchResultsList js-draggableList']")
	private  WebElement searchResultBox;

	//	@FindBy(xpath = "//div[contains(@class,'SearchResultV3-thumb')][1]/img")
	@FindBy(xpath=".//*[@id='main']/div[5]/div/div[2]/a")
	private WebElement resultThumbnail;



	public HomePage(WebDriver driver){
		this.driver=driver;
		AjaxElementLocatorFactory aFactory= new AjaxElementLocatorFactory(driver, 25);
		PageFactory.initElements(aFactory, this);
		myWait = new WebDriverWait(driver, 25);
		jse = (JavascriptExecutor)driver;
	}




	public String getTitle(){
		return driver
				.getTitle()
				.toString();
	}

	public boolean getSearchResultStatus() {
		return
				searchResultBox.isDisplayed();
	}


	public String getVideoTypeRef() {
		String str= "";
		str = resultThumbnail.getAttribute("href");
		return str;
	}

	public String getInnerHTML() {
		return driver.findElement(By.xpath("//body//noscript")).getAttribute("innerHTML");
	}


}
