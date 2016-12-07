package com.seleniumtests.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by laxmisomni on 30-11-16.
 */
public class InLoggenPage extends BasePage {


    @FindBy(id = "accept-cookie-choice")
    private WebElement acceptCookie;


    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;


    @FindBy(xpath = "//input[contains(@value,'Inloggen bij Mijn Aegon')]")
    private WebElement submitButton;


    public InLoggenPage(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory aFactory= new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(aFactory, this);
        jse = (JavascriptExecutor)driver;
    }

    public boolean cookieMessagePresence() {
        if(driver.findElement(By.xpath("//div[contains(@class,'cookiewall-basic')]")).isDisplayed()) {
            return true;
        }
        return false;
    }


    public void acceptCookieMessage() {
        acceptCookie.click();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }


    public void login(final String uName, final String sPass) {
        _waitUntil(username);
        _waitUntil(password);
        _waitUntil(submitButton);

        username.clear();
        username.sendKeys(uName);
        password.clear();
        password.sendKeys(sPass);
        submitButton.click();
    }
}
