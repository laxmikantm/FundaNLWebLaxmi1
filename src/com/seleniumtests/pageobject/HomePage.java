package com.seleniumtests.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

	private static final String HOME_PAGE = "http://www.funda.nl";

	private WebDriver driver;
    By maxBudgetDropdown = By.name("filter_FundaHuurPrijsTot");

	@FindBy(css="#autocomplete-input[type='search']")
	private WebElement searchBox;

//	@FindBy(css="div[.^=search-block] > button.button-primary-alternative")
	@FindBy(xpath="//button[contains(.,'Zoek')]")
    private WebElement searchButton;



	public HomePage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory aFactory= new AjaxElementLocatorFactory(driver, 20);
		PageFactory.initElements(aFactory, this);
		jse = (JavascriptExecutor)driver;
	}

	public String getPageURL() {
		return super
				.getPageURL(driver);
	}


	public String getTitle(){
		return driver.getTitle();
	}

	public String getInnerHTML() {
		return driver.findElement(By.xpath("//body//noscript")).getAttribute("innerHTML");
	}

	public String returnTextSuggestion() {
		return searchBox.getAttribute("placeholder");
	}

	public ResultsPage performSearch(final String searchKeyWord, final String dist, final String maxBudget) {
		searchBox.clear();
		searchBox.sendKeys(searchKeyWord);

        Select drpDistance = new Select(driver.findElement(By.id("Afstand")));
        drpDistance.selectByVisibleText(dist);

        Select maxBudgetSel = new Select(driver.findElement(maxBudgetDropdown));
        maxBudgetSel.selectByVisibleText(maxBudget);

        searchButton.click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		return new ResultsPage(driver);
	}

}
