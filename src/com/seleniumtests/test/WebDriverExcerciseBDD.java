/**
 * 
 */
package com.seleniumtests.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.pageobject.LandingPage;
import com.seleniumtests.pageobject.LoginPage;
import com.seleniumtests.support.Helper;

import junit.framework.TestListener;
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
	LoginPage loginPage;
	LandingPage landingPage;
	

	@Given("^I am on the login page$")
	public void login_page(){
		
		 loginPage= new LoginPage(driver);		 
		 loginPage
				.getBasePage();

	}

	@When("^I fill <username> and <password> on the login page$")
	public void i_fill_username_and_password_on_the_login_page(String sUserName, String sPassword) {
		
		loginPage
			.keyInLogin
				(sUserName, sPassword);	
		
	}

	@When("^I click keyboard enter key in order to login$")
	public void i_click_keyboard_enter_key_in_order_to_login(){
			
		 landingPage=loginPage.signIn();
	}


	
	@Then("^the <status> should be shown$")
	public void the_status_should_be_shown(){
		Assert
				.assertEquals
					(landingPage.verifyPageURL()
							, "New location URL's not as per expected");
						
		
		Assert
			.assertTrue
				(landingPage
					.getTitle()
							.equalsIgnoreCase(Helper.EXPECTED_TITLE_LANDING_PAGE));
	}



}
