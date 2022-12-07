package org.finalExamTae.tests.stepDefinitions.mobile;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.finalExamTae.pageObjects.screens.*;
import org.finalExamTae.reporting.Reporter;
import org.testng.Assert;

public class mobileStepDefinitions {
    private TutorialScreen tutorialScreen;
    private DashBoardScreen dashBoardScreen;
    private MapScreen mapScreen;
    private MenuScreen menuScreen;
    private PrivacyAndLegalScreen privacyAndLegalScreen;
    private AddPlansScreen addPlansScreen;

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
        Assert.assertTrue(mapScreen.isShowListDisplayed(), "List button is  visible");
        Reporter.info("Verifying Category button is visible");
        Assert.assertTrue(mapScreen.isCategoryDisplayed(), "Category button is visible");
        Reporter.info("Verifying Filter button is visible");
        Assert.assertTrue(mapScreen.isHotelsOptionDisplayed(), "Filter button is not visible");
    }

    /**
     * this method clicks  in the category list
     */
    @When("I tap on the Category List button")
    public void iTapOnTheCategoryListButton() {
        mapScreen.clickCategoryList();
    }

    /**
     * this method verifies the category list is displayed, then verifies all the elements
     * are present
     */
    @Then("All the categories, including Hotels option, should be displayed")
    public void differentCategoriesIncludingHotelsOptionShouldBeDisplayed() {
        Reporter.info("Verifying Category List options are correct:");
        Assert.assertTrue(mapScreen.verifyCategoryOptions(), "Listed categories are correct");
        Reporter.info("Verifying Hotels option is visible");
        Assert.assertTrue(mapScreen.isHotelsOptionDisplayed(), "Hotels' option is visible");
    }

    /**
     * this method helps to navigate to the menu screen
     */
    @Given("I am in the menu screen")
    public void iAmInTheMenuScreen() {
        Reporter.info("Entering in the Menu view");
        menuScreen = dashBoardScreen.goToMenuScreen();
    }

    /**
     * this method verifies if the elements in the menu screen are displayed
     */
    @Then("All the categories in the menu screen are displayed")
    public void theMenuViewAndItsElementsShouldBeDisplayed() {
        Reporter.info("Verifying menu screen categories");
        Reporter.info("Menu options are properly displayed");
        Assert.assertTrue(menuScreen.checkMenuOptions(), "All menu options are displayed");
    }

    /**
     * this method scrolls to the end of the screen
     */
    @When("I scroll down")
    public void iScrollDown() {
        menuScreen.scrollDown(4);
    }

    /**
     * Allows to scroll to the 'Privacy And Legal' option and click it for displaying its menu.
     */
    @When("I select the Privacy & Legal option")
    public void iSelectThePrivacyLegalOption() {
        Reporter.info("Displaying Privacy & Legal options");
        privacyAndLegalScreen = menuScreen.goToPrivacyAndLegalScreen();
    }

    /**
     * Verifies if all options in 'Privacy & Legal' were properly displayed.
     */
    @Then("The Privacy & Legal options should be displayed")
    public void thePrivacyLegalOptionsShouldBeDisplayed() {
        Reporter.info("Verifying Privacy & Legal menu options");
        Assert.assertTrue(privacyAndLegalScreen.verifyPrivacyAndLegalOptions(), "Privacy & Legal options are displayed");
    }

    /**
     * navigate to the add plan screen
     */
    @When("I select the add Plans option")
    public void iSelectTheAddPlansOption() {
        Reporter.info("Navigating to the add plans screen");
        addPlansScreen = dashBoardScreen.goToAddPlansScreen();
    }

    /**
     * verifies if the dining availability option is displayed
     */
    @Then("The Check Dining Availability option should be displayed")
    public void theCheckDiningAvailabilityOptionShouldBeDisplayed() {
        Assert.assertTrue(addPlansScreen.isCheckingDiningAvailabilityDisplayed()
                , "Check dining availability is displayed");
    }
}
