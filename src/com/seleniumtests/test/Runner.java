/**
 *
 */
package com.seleniumtests.test;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

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
