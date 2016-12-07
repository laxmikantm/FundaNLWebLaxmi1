package com.seleniumtests.test;

import com.seleniumtests.core.SelTestCase;
import com.seleniumtests.pageobject.InLoggenPage;
import com.seleniumtests.rest.controller.RestExecutor;
import com.seleniumtests.rest.controller.RestValidator;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.awt.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by laxmisomni on 29-11-16.
 */
public class Stepdefs extends SelTestCase {
    private static RestExecutor executor;
    private String autharisationURL;
    private String uatEnvURL;
    private RestValidator validator;

    private String masterUser = "";
    private String masterUserpass = "";

    private InLoggenPage inLoggenPage;


    @Before("@API")
    public void beforeScenario() throws IOException, AWTException {
        initalisation("FF");
    }

    @Given("^I am logged onto the UAT environment$")
    public void iAmLoggedOntoTheUATEnvironment() throws InterruptedException {
        autharisationURL = "https://api.uat.aegon.nl";
        uatEnvURL = "";

        driver.get(uatEnvURL);

        inLoggenPage = new InLoggenPage(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        if(inLoggenPage.cookieMessagePresence()) {
            inLoggenPage.acceptCookieMessage();
        }

        inLoggenPage.login(masterUser, masterUserpass);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }


    @When("^I send get request to authorisation Api$")
    public void iSendGetRequestToAuthorisationApi() throws Throwable {
        executor = new RestExecutor(autharisationURL);
        validator = executor.get("");
    }


    @Then("^I should get ¨(\\d+)¨ status code$")
    public void iShouldGetStatusCode(final int sCode) throws Throwable {
        Assert.assertTrue("Error: Response code doesn't match",
                (validator.getResponse().getResponseCode())==sCode);
    }


    @After("@API")
    public void teardown() {
        driver.manage().deleteAllCookies();
        driver.close();
        driver.quit();
    }
}
