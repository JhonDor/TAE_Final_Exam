package org.finalExamTae.runners;

import io.cucumber.java.BeforeAll;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.finalExamTae.configuration.DriverWeb;
import org.finalExamTae.pageObjects.pages.HomePage;
import org.finalExamTae.reporting.Reporter;

/**
 * Runner class for Web automation feature.
 */
@CucumberOptions(
        features = "src/test/java/org/finalExamTae/tests/features",
        glue = {"org.finalExamTae.tests.stepDefinitions"},
        tags = "@webAutomation")
public class RunCucumberTestsWeb extends AbstractTestNGCucumberTests {


}
