/**
 * (c) Laxmi Somni
 */
package com.seleniumtests.test;

import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.pageobject.HomePage;
import com.seleniumtests.pageobject.LandingPage;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @author Laxmi.Somni
 *
 */
public class WebDriverExcerciseBDD extends SelTestCase {

	WebDriverExcercise WebDriverExcercise=new WebDriverExcercise();
	HomePage loginPage;
	LandingPage landingPage;


	@Given("^I am on the Pond5 Home Page$")
	public void landingPage(){

		landingPage= new LandingPage(driver);
		landingPage.
		getBasePage(driver);

	}

	@When("^I fill in  \"([^\"]*)\" in search box$")
	public void i_fill_in_search_Keyword(String sKeyWord) {

		landingPage
		.performSearch(sKeyWord);

	}



	@When("^I fill in <keyword> in search box$")
	public void i_fill_in_keyword_in_search_box() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
	}

	@When("^I click on Find button$")
	public void i_click_on_Find_button() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new PendingException();
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

	@Then("^the search results page should have \"([^\"]*)\"$")
	public void the_search_results_page_should_have(String arg1, DataTable arg2) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		// For automatic transformation, change DataTable to one of
		// List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
		// E,K,V must be a scalar (String, Integer, Date, enum etc)
		throw new PendingException();
	}


}
