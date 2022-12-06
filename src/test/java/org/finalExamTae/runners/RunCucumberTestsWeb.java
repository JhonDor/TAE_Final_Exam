package org.finalExamTae.runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for Web automation feature.
 */
@CucumberOptions(
        features = "src/test/java/org/finalExamTae/tests/features",
        glue = {"org.finalExamTae.tests.stepDefinitions.web"},
        tags = "@webAutomation")
public class RunCucumberTestsWeb extends AbstractTestNGCucumberTests {


}
