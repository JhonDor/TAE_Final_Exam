package org.finalExamTae.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/**
 * Runner class for Mobile automation feature.
 */
@CucumberOptions(
        features = "src/test/java/org/finalExamTae/tests/features",
        glue = {"org.finalExamTae.tests.stepDefinitions.mobile"},
        tags = "@mobileAutomation")
public class RunCucumberTestsMobile extends AbstractTestNGCucumberTests {
}
