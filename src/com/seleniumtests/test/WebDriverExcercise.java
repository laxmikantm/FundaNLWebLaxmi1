package com.seleniumtests.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.annotations.Test;

import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.dataobject.LoginData;
import com.seleniumtests.dataobject.SKUData;
import com.seleniumtests.pageobject.AddNewSKUPage;
import com.seleniumtests.pageobject.LoginPage;
import com.seleniumtests.pageobject.LandingPage;
import com.seleniumtests.pageobject.SKUSHomePage;
import com.seleniumtests.support.Helper;

public class WebDriverExcercise extends SelTestCase implements ITestNGListener {

	LoginPage loginPage;
	LandingPage landingPage;
	SKUSHomePage skusPage;
	AddNewSKUPage addNewSKUPage;

	@Test(dataProvider = "loginData", dataProviderClass = LoginData.class)
	public void loginProcedure(LoginData loginData) throws IOException {
		
		loginPage= new LoginPage(driver);
		loginPage
				.getBasePage();
		loginPage
				.keyInLogin
						(loginData.getUsername(), loginData.getPassword());			
		 landingPage=loginPage.signIn();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			Helper.takeScreenSnapShot(driver, "After_Login");
		
		softAssert
			.assertTrue
					(landingPage.verifyPageURL()
							, "Landing Page URL's not as per expected");
						
		
		softAssert
			.assertTrue
				(landingPage
					.getPageTitle(driver)
							.equalsIgnoreCase(Helper.EXPECTED_TITLE_LANDING_PAGE));

	}
	
	
	@Test(dependsOnMethods="loginProcedure")
	public void navigateToSKUS() throws IOException{
		skusPage=landingPage.navigateToSKUS();
			Helper.takeScreenSnapShot(driver, "After_Navigate_to_SKUS");			
			driver.manage()
					.timeouts()
							.implicitlyWait(4, TimeUnit.SECONDS);
		
		softAssert
			.assertTrue
					(skusPage
							.verifyPageURL()
									, "SKUS page URL is not as per expected");
		
		softAssert
			.assertTrue
				(skusPage
						.getPageTitle(driver)
								.equalsIgnoreCase(Helper.EXPECTED_TITLE_SKUSPAGE));
	}
	
	@Test(dependsOnMethods="navigateToSKUS",dataProvider = "skuData", dataProviderClass = SKUData.class)
	public void createSKUResource(SKUData skuData) throws IOException{
		
		addNewSKUPage=skusPage.createNewSKU();
		skusPage=addNewSKUPage.addNewSKU(skuData);
			Helper.takeScreenSnapShot(driver, "After-Submitting-new-SKUData");
		
		
	}
	
	
}
