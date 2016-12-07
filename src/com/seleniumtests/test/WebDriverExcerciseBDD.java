/**
 * (c) Laxmi Somni
 */
package com.seleniumtests.test;

import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.pageobject.ResultsPage;
import com.seleniumtests.pageobject.HomePage;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.awt.*;
import java.io.IOException;

/**
 * @author Laxmi.Somni
 *
 */
public class WebDriverExcerciseBDD extends SelTestCase {

	WebDriverExcercise webDriverExcercise;
	ResultsPage loginPage;
	HomePage homePage;


	@Before("@runX")
	public void beforeScenario() throws IOException, AWTException {
		initalisation("FF"); // Change to FF if necessary
	}

    @And("^I am on the Funda Home Page$")
	public void landingPage(){
		webDriverExcercise = new WebDriverExcercise();
		homePage = new HomePage(driver);
		homePage.getRentPage(driver);

	}

	@When("^I fill in  \"([^\"]*)\" in search box$")
	public void i_fill_in_search_Keyword(String sKeyWord) {


	}


	@Then("^the search results for the \"([^\"]*)\" should be displayed$")
	public void the_search_results_for_the_should_be_displayed(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^the search results page should have correct title & header$")
	public void the_search_results_page_should_have_correct_title_header() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@Then("^the search results page should have correct page footer$")
	public void the_search_results_page_should_have_correct_page_footer() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}




    @When("^I search for \"([^\"]*)\" location$")
    public void iSearchForLocation(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

	@Then("^I should be shown with the result for the specificed criteria$")
	public void iShouldBeShownWithTheResultForTheSpecificedCriteria() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}


}
