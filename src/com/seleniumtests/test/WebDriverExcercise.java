package com.seleniumtests.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.ITestNGListener;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.dataobject.LandingPageData;
import com.seleniumtests.pageobject.HomePage;
import com.seleniumtests.pageobject.LandingPage;
import com.seleniumtests.support.Helper;

public class WebDriverExcercise extends SelTestCase implements ITestNGListener {


	HomePage homePage;
	LandingPage landingPage;



	@Test(testName = "Search Produre",dataProvider = "searchData", dataProviderClass = LandingPageData.class)
	public void searchProcedure(LandingPageData landingPageData) throws IOException {

		landingPage= new LandingPage(driver);
		landingPage.
		getBasePage(driver);


		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		Helper.takeScreenSnapShot(driver, "After_Landing");

		softAssert
		.assertTrue
		(landingPage.getPageURL()
				, "Landing Page URL's not as per expected");


		softAssert
		.assertTrue
		(landingPage
				.getPageTitle(driver)
				.equalsIgnoreCase(Helper.EXPECTED_TITLE_LANDING_PAGE));

		homePage = landingPage
				.performSearch(landingPageData.getSearchKeyword());

		Reporter.log("**Search Performed for the Supplied Keyword.**");


	}

	@Test(testName = "Check if Videos Returned in Result", dependsOnMethods="searchProcedure")
	public void testIfVideosReturnedInResult() {
		softAssert
		.assertTrue((homePage.getSearchResultStatus()==true), "Error: Search Result not displayed for given keyword.");

		Reporter.log("**One or more Number video(s) returned in the search result for the supplied keyword.**");

	}

	@Test(testName = "Check if Correct Type of Video for the given Keyword",dependsOnMethods="testIfVideosReturnedInResult")
	public void testIfCorrectTypeofVideoPresentInResult() {
		softAssert
		.assertTrue(homePage.getVideoTypeRef().contains(Helper.EXPECTED_VIDEO_TYPE), "Error: Search result Thumbnail URL does not contain Car type");

		Reporter.log("**Correct Type of video asset returned in the result.**");

	}


	@Test(testName = "BackEnd: Check if Google Analytics Present in DOM.")
	public void testForGoogleAnalyticsPresent() {
		softAssert
		.assertTrue(homePage.getInnerHTML().contains(Helper.GOOGLE_TAGMANAGER), "Error: Google Tag Manager script not present in HTML.");
	}


}
