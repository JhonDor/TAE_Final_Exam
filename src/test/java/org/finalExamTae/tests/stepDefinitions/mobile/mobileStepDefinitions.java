package org.finalExamTae.tests.stepDefinitions.mobile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.finalExamTae.pageObjects.screens.*;
import org.finalExamTae.reporting.Reporter;
import org.testng.Assert;

public class mobileStepDefinitions {
    private TutorialScreen tutorialScreen;
    private DashBoardScreen dashBoardScreen;
    private MapScreen mapScreen;
    private MenuScreen menuScreen;
    private PrivacyAndLegalScreen privacyAndLegalScreen;
    //private AddPlansScreen addPlansScreen;

    /**
     * navigates to the dashboard screen
     */
    @Given("I am in the Dashboard screen")
    public void iAmInTheDashboardScreen() {
        tutorialScreen = new TutorialScreen(MobileHooks.getDriver());
        tutorialScreen.startPermissionsProcess();
        dashBoardScreen = tutorialScreen.shareLocationPermissions();
    }

    /**
     * navigates to the map screen
     */
    @Given("I am in the Map screen")
    public void iAmInTheMapScreen() {
        Reporter.info("I am in the map screen");
        mapScreen = dashBoardScreen.goToMapScreen();
    }
    /**
     * Verifies if the followings elements in the map screen are displayed:
     */
    @Then("The map screen and its elements should be displayed")
    public void theMapViewAndItsElementsShouldBeDisplayed() {
        Reporter.info("Verifying Map view elements:");
        Reporter.info("Verifying List button is visible");
        Assert.assertTrue(mapScreen.isShowListDisplayed(), "List button is not visible");
        Reporter.info("Verifying Category button is visible");
        Assert.assertTrue(mapScreen.isCategoryDisplayed(), "Category button is not visible");
        Reporter.info("Verifying Filter button is visible");
        Assert.assertTrue(mapScreen.isFilterDisplayed(), "Filter button is not visible");
    }


}
