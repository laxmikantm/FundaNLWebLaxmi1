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

public class LoginPage extends BasePage{
	
	@FindBy(id="username")
	private WebElement usernameField;
	
	@FindBy(id="password")
	private WebElement passwordField;
	
//	@FindBy(css=".btn.btn-primary.btn-block")
//	@FindBy(css="fieldset>button[type=submit]")
	@FindBy(xpath="//button[contains(.,'Sign In')]")
	private WebElement SignInBtn;
	
	public LoginPage(WebDriver driver){
		this.driver=driver;
		AjaxElementLocatorFactory aFactory= new AjaxElementLocatorFactory(driver, 35);
		PageFactory.initElements(aFactory, this);
		
//		myWait = new WebDriverWait(driver, 25);	
		jse = (JavascriptExecutor)driver;
	}
	
	public void getBasePage(){
		super.getBasePage();
	}
	
	
	public LoginPage keyInLogin(String sUserName, String sPass){
		usernameField.clear();
		usernameField.sendKeys(sUserName);
		passwordField.clear();
		passwordField.sendKeys(sPass);
		return this;
		
	}
	
	public LandingPage signIn(){
		passwordField.sendKeys(Keys.RETURN);
		return new LandingPage(driver);
	}
	
	

}
