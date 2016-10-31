/**
 *
 */
package com.seleniumtests.test;

import com.seleniumtests.core.SelTestCase;
import cucumber.api.java.Before;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

import java.awt.*;
import java.io.IOException;

/**
 * @author Laxmi.Somni
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/com/seleniumtests/resources"}
		,format ={"pretty", "html:target/cucumber-html-report"}
		,glue={"com.seleniumtests.test"}
		,tags = {"@runX"}
		)
public class Runner {
}
