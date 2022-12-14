package org.finalExamTae.tests.stepDefinitions.web;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.finalExamTae.pageObjects.pages.HomePage;
import org.finalExamTae.pageObjects.pages.WatchPage;
import org.finalExamTae.reporting.Reporter;
import org.finalExamTae.utils.webtestdata.WebData;
import org.testng.Assert;

import static java.lang.String.format;

/**
 * this is the class for the step definitions
 */
public class EspnWebStepsDefinitions {
    private HomePage homePage;
    private WatchPage watchPage;

    private final String USER_WELCOME = "Welcome" + WebData.returnData("user") + "!";



    /**
     * This method opens the browser and navigates to the homepage of ESPN
     */
    @Given("I am in the ESPN website home page")
    public void iAmInTheESPNWebsiteHomePage() {
        Reporter.info(format("Navigating to %s", WebData.returnData("url")));
        homePage = new HomePage(WebHooks.getDriver());

    }

    /**
     * This method opens the login modal
     */

    @Given("I am in the Log In modal")
    public void iAmInTheLogInModal() {

        homePage.mouseOverUserIcon();
        homePage.clickOnLoginOption();
        homePage.switchToIframe();
    }

    /**
     * This method verifies that all the elements in the login modal are displayed
     */
    @Then("The Log in modal, ESPN Logo, Log in button and Sign up button should be displayed")
    public void loginModalAndElementsAreDisplayed() {
        Reporter.info("Verifying the login modal is visible");
        Assert.assertTrue(homePage.loginModalIsDisplayed(), "Log in modal is visible");

        Reporter.info("Verifying the ESPN logo is visible");
        Assert.assertTrue(homePage.espnLogoIsDisplayed(), "ESPN logo is visible");

        Reporter.info("Verifying the Log In button is visible");
        Assert.assertTrue(homePage.loginButtonIsDisplayed(), "Log In button is visible");

        Reporter.info("Verifying the Sign Up button is visible");
        Assert.assertTrue(homePage.signUpButtonIsDisplayed(), "Sign Up button is visible");
    }

    /**
     * This method clicks in the sign-up button
     */
    @When("I click on the Sing Up button")
    public void iClickOnTheSingUpButton() {
        homePage.clickOnSignUpButtonIframe();
    }

    /**
     *This method verifies all the elements in the log in modal are displayed
     */
    @Then("All the elements to do the sign up should be displayed")
    public void allTheElementsForTheSignUpProcedureShouldBeDisplayed() {
        Reporter.info("Verifying the Sign Up title is visible");
        Assert.assertTrue(homePage.signUPTitleIsDisplayed(), "Sign Up title is visible");

        Reporter.info("Verifying the First Name input is visible");
        Assert.assertTrue(homePage.firstNameInputIsDisplayed(), "First Name input is visible");

        Reporter.info("Verifying the Last Name input is visible");
        Assert.assertTrue(homePage.lastNameInputIsDisplayed(), "Last Name input is visible");

        Reporter.info("Verifying the Email input is visible");
        Assert.assertTrue(homePage.emailInputForSignUpIsDisplayed(), "Email input is visible");

        Reporter.info("Verifying the Password input is visible");
        Assert.assertTrue(homePage.passwordInputForSignUpIsDisplayed(), "Password input is visible");

        Reporter.info("Verifying the Sign Up button is visible");
        Assert.assertTrue(homePage.signUpButtonForSignUpIsDisplayed(), "Sign Up button is visible");

        Reporter.info("Verifying the Close button is visible");
        Assert.assertTrue(homePage.closeIframeButtonIsDisplayed(), "Close button is visible");
    }

    /**
     * this method creates a new user
     */
    @And("I create a new user")
    public void enterAllInformationForSigningUp() {
        String email = homePage.createEmail();
        homePage.typeOnFirstNameInput(WebData.returnData("user"));
        homePage.typeOnLastNameInput(WebData.returnData("user"));
        homePage.typeOnEmailInputForSignUp(email);
        homePage.typeOnPasswordInputForSignUp(WebData.returnData("password"));
        homePage.mouseOverSignUpForSignUpButtonIframe();
        homePage.clickOnSignUpForSignUpButtonIframe();
        homePage.exitIframe();

    }

    /**
     * this method helps with the whole creation of a new user
     */
    @Given("I created a new user")
    public void iCreatedANewUser(){
        this.iAmInTheLogInModal();
        this.iClickOnTheSingUpButton();
        this.enterAllInformationForSigningUp();
        homePage.waitForLogin();
        homePage.mouseOverUserIcon();
    }

    /**
     * this method helps the user going to the watch page
     */
    @When("I go to the Watch page")
    public void iGoToTheWatchPage(){
        Reporter.info("Going into watch page");

        watchPage = homePage.goToWatchPage();
    }

    /**
     * this method verifies all the elements in the watch page are displayed
     */
    @Then("I validate all the elements are displayed")
    public void thePageElementsShouldBeProperlyDisplayed() {
        Reporter.info("Verifying all cards in the second carousel have a title");
        Assert.assertTrue(watchPage.verifyCardsTitle(), "All cards in the second carousel have a title");

        Reporter.info("Verifying all cards in the second carousel have a description");
        Assert.assertTrue(watchPage.verifyCardsDescription(), "All cards in the second carousel have a description");

        watchPage.clickCard();
        Reporter.info("Verifying Close button is displayed");
        Assert.assertTrue(watchPage.closeButtonModalIsDisplayed(), "Close button is displayed");
        watchPage.clickOnCloseButtonPopUp();
    }

    /**
     * this method helps going back to the home-page
     */
    @And("I should be able to return to the Home page")
    public void iShouldBeAbleToReturnToTheHomePage() {
        watchPage.returnToHomePage();
        Reporter.info("Verifying if I have returned to the Home page");
        Assert.assertTrue(homePage.userIconIsDisplayed(), "I returned to the Home page");
    }

    /**
     * This method verifies the user was created and is logged in
     */
    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        //homePage.waitForLogin();
        homePage.mouseOverUserIcon();
        Reporter.info("Verifying the account was created");
        Assert.assertEquals(homePage.verifyWelcomeText(), USER_WELCOME, "Account was created");

    }

    /**
     * this method does a mouse over on the user icon
     */
    @When("I move the mouse over the User Icon")
    public void iMoveTheMouseOverTheUserIcon() {
        homePage.mouseOverUserIcon();
    }

    /**
     * this method verifies the welcome text displays the username
     */
    @Then("The welcome text is displayed and my name are displayed")
    public void theWelcomeTextIsDisplayedAndMyNameAreDisplayed() {
        Reporter.info("Verifying the welcome text is properly displayed with a name");
        Assert.assertEquals(homePage.verifyWelcomeText(), USER_WELCOME, "The welcome text is properly displayed with a name");
    }

    /**
     * this method does the log-out
     */
    @When("I log out")
    public void iLogOut(){
        homePage.mouseOverUserIcon();
        homePage.clickOnLogout();
    }

    /**
     * this method verifies the welcome text doesn't display a username
     */
    @Then("The welcome text is displayed without a username")
    public void theWelcomeTextIsDisplayedWithoutMyName(){
        Reporter.info("Verifying the welcome text is properly displayed without a name");
        homePage.refreshPage();

        homePage.mouseOverUserIcon();
        Assert.assertEquals(homePage.verifyWelcomeText(), "Welcome!", "The welcome text is properly displayed without a name");
    }
}
