package com.seleniumtests.pageobject;
/*Laxmi Somni 2016 */
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage extends BasePage{


	@FindBy(className = "search-content")
	private WebElement searchResultArea;

	@FindBy(className = "search-sidebar-filters")
	private WebElement leftHandPane;


	public ResultsPage(WebDriver driver){
		this.driver=driver;
		AjaxElementLocatorFactory aFactory= new AjaxElementLocatorFactory(driver, 25);
		PageFactory.initElements(aFactory, this);
		myWait = new WebDriverWait(driver, 10);
		jse = (JavascriptExecutor)driver;
	}

	public String getTitle(){
		return driver
				.getTitle();
	}

	public boolean getSearchResultStatus() {
		return
				searchResultArea.isDisplayed();
	}

	public boolean getLeftHandPaneStatus() {
		return
				leftHandPane.isDisplayed();
	}

}
