package com.seleniumtests.test;
/* Laxmi Somni 2016 */

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.ITestNGListener;
import org.testng.Reporter;
import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.dataobject.HomePageData;
import com.seleniumtests.pageobject.ResultsPage;
import com.seleniumtests.pageobject.HomePage;
import com.seleniumtests.support.Helper;
import org.testng.annotations.Test;

import static com.seleniumtests.support.Helper.SEARCH_RESULT_PAGE_FOR_HAGUE;

public class WebDriverExcercise extends SelTestCase implements ITestNGListener {
    ResultsPage resultsPage;
    HomePage homePage;

    @Test(testName = "Verify Home Page", priority = 0)
    public void verifyOpeningHomePage() throws IOException {

        homePage = new HomePage(driver);
        homePage.
                getRentPage(driver);

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        Helper.takeScreenSnapShot(driver, "After_Landing");

        softAssert
                .assertTrue
                        (homePage.getPageURL().contains(Helper.BaseURL)
                                , "Landing Page URL's not as per expected");


        softAssert
                .assertTrue
                        (homePage
                                .getPageTitle(driver)
                                .equalsIgnoreCase(Helper.EXPECTED_TITLE_HOME_PAGE));

        Reporter.log("**Verified that we are on intended Homepage.**");


    }

    @Test(testName = "BackEnd: Check if Google Analytics Present in DOM.", priority = 1)
    public void testForGoogleAnalyticsPresent() {
        Assert
                .assertTrue(homePage.getInnerHTML().contains(Helper.GOOGLE_TAGMANAGER),
                        "Error: Google Tag Manager script not present in HTML.");
    }


    @Test(testName = "Default search text suggestion", priority = 1)
    public void validateDefaultSuggestionText() {
        softAssert
                .assertTrue(homePage.returnTextSuggestion().equalsIgnoreCase(Helper.SUGGESTION_TEXT),
                        "Error: Default suggestion text isn't as per expected.");
    }

    @Test(testName = "Search Produre", dataProvider = "searchData", dataProviderClass = HomePageData.class, dependsOnMethods = "verifyOpeningHomePage")
    public void searchProcedure(HomePageData homePageData) throws IOException {

        resultsPage = homePage
                .performSearch(homePageData.getSearchKeyword(), homePageData.getDistance(), homePageData.getMaxBudget());

        softAssert.assertTrue(resultsPage.getTitle().equalsIgnoreCase(SEARCH_RESULT_PAGE_FOR_HAGUE),
                "Error: Not landed on correct search result page.");

        softAssert
                .assertTrue((resultsPage.getSearchResultStatus()),
                        "Error: Search Result Box is not rendered.");


        Reporter.log("**Search Performed.**");


    }

    @Test(testName = "Check if Left Hand Pane is present on Search reult page", dependsOnMethods = "searchProcedure")
    public void testForLeftHandPanePresence() {
        softAssert
                .assertTrue((resultsPage.getLeftHandPaneStatus()), "Error: Left hand pane not displayed on the search result page.");
    }

}
