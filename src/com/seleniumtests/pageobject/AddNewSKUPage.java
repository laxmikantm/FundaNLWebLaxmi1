/**
 * 
 */
package com.seleniumtests.pageobject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.seleniumtests.dataobject.SKUData;
import com.seleniumtests.support.Helper;

/**
 * @author Laxmi.Somni
 *
 */
public class AddNewSKUPage extends BasePage {
	
	@FindBy(name="code")
	private WebElement SKUCodeField;
	
	@FindBy(xpath="//input[@name='description']")
	private WebElement descriptionField;
	
	@FindBy(name="unitCost")
	private WebElement unitCostField;
	
//	@FindBy(xpath="//span[contains(text(),'Search for a product')]")
	@FindBy(xpath=".//*[@id='select2-drop-mask']")
	private WebElement searchForProdType;
	
	@FindBy(css="div[class='control-group']>div>input[type='text'][name='_id']")
	private WebElement ProdTypeTxtBox;
	
	@FindBy(name="maxItems")
	private WebElement maxItemsField;
	
	@FindBy(css="div[class='control-group']>div>.btn.btn-green")
	private WebElement saveBtn;
	
	
	public AddNewSKUPage(WebDriver driver) {
		this.driver = driver;
		AjaxElementLocatorFactory aFactory= new AjaxElementLocatorFactory(driver, 35);
		PageFactory.initElements(aFactory, this);		
		myWait = new WebDriverWait(driver, 25);	
		jse = (JavascriptExecutor)driver;
	}
	
	
	public AddNewSKUPage enterSKUCode(String sSKUCode){
		SKUCodeField.clear();
		SKUCodeField.sendKeys(sSKUCode);	
		return this;
		
	}
	
	public AddNewSKUPage enterDescription(String sDescription){
		descriptionField.clear();
		descriptionField.sendKeys(sDescription);
		jse.executeScript("document.getElementsByName(\"description\").value=\""+sDescription+"\"");
		return this;	
	}
	
	public AddNewSKUPage enterUnitCost(int UnitCost){
		unitCostField.clear();
		unitCostField.sendKeys(Integer.toString(UnitCost));		
		return this;	
	}
	
	public AddNewSKUPage enterProductType(String sProductType){
		searchForProdType.click();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		ProdTypeTxtBox.clear();
		ProdTypeTxtBox.sendKeys(sProductType);		
		return this;
	}
	
	
	public AddNewSKUPage enterMaxItems(int MaxItems){
		maxItemsField.clear();
		maxItemsField.sendKeys(Integer.toString(MaxItems));		
		return this;
	}
	
	public SKUSHomePage clickOnSave(){
		saveBtn.click();
		return new SKUSHomePage(driver);
	}
	
	public SKUSHomePage addNewSKU(SKUData skuData) throws IOException {
		Helper.takeScreenSnapShot(driver, "Before_Filling-in_data");
		
return 	(enterSKUCode(skuData.getSKUCodePart())
		.enterDescription(skuData.getsDescription())
		.enterUnitCost(skuData.getUnitCost())
		.enterProductType(skuData.getsProductTypeValue())
		.enterMaxItems(skuData.getMaxItems())
		.clickOnSave());	 	
		
	}

}
