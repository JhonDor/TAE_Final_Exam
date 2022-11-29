package org.finalExamTae.tests.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.finalExamTae.configuration.DriverWeb;
import org.finalExamTae.pageObjects.pages.HomePage;
import org.finalExamTae.pageObjects.pages.WatchPage;
import org.finalExamTae.reporting.Reporter;
import org.testng.Assert;

import static java.lang.String.format;

public class EspnWebStepsDefinitions {
    private static DriverWeb driver;
    private HomePage homePage;
    private WatchPage watchPage;
    private final String URL = "https://www.espnqa.com/?src=com&_adblock=true&espn=cloud";
    private final String USER = "Test";
    private static String email;
    private final String EMAIL_LOGIN = "testing2050@gmail.com";
    private final String PASSWORD = "123espn";
    private final String USER_WELCOME = "Welcome" + USER + "!";


    @Before
    public static void scenarioSetUp() {
        driver = new DriverWeb();
        Reporter.info("Deleting all cookies");
        driver.getDriver().manage().deleteAllCookies();
    }
/**
    @After
    public static void tearDown() {
        driver.getDriver().quit();
    }*/

    @Given("I am in the ESPN website home page")
    public void iAmInTheESPNWebsiteHomePage() {
        Reporter.info(format("Navigating to %s", URL));
        driver.getDriver().get(URL);
        driver.getDriver().manage().window().maximize();
        homePage = new HomePage(driver.getDriver());

    }


    @Given("I am in the Log In modal")
    public void iAmInTheLogInModal() {

        homePage.mouseOverUserIcon();
        homePage.clickOnLoginOption();
        homePage.switchToIframe();
    }

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

    @When("I click on the Sing Up button")
    public void iClickOnTheSingUpButton() {
        homePage.clickOnSignUpButtonIframe();
    }

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

    @And("I create a new user")
    public void enterAllInformationForSigningUp() throws InterruptedException {
        email = homePage.createEmail();
        homePage.typeOnFirstNameInput(USER);
        homePage.typeOnLastNameInput(USER);
        homePage.typeOnEmailInputForSignUp(email);
        homePage.typeOnPasswordInputForSignUp(PASSWORD);
        homePage.mouseOverSignUpForSignUpButtonIframe();
        homePage.clickOnSignUpForSignUpButtonIframe();
        homePage.exitIframe();

        //homePage.clickOnLogout();
        //Thread.sleep(15000);
       // homePage.mouseOverUserIcon();
        //homePage.mouseOverUserIcon();
        //homePage.refreshPage();
    }

    @Given("I created a new user")
    public void iCreatedANewUser(){
        homePage.mouseOverUserIcon();
        homePage.clickOnLoginOption();
        homePage.switchToIframe();
        homePage.clickOnSignUpButtonIframe();
        email = homePage.createEmail();
        homePage.typeOnFirstNameInput(USER);
        homePage.typeOnLastNameInput(USER);
        homePage.typeOnEmailInputForSignUp(email);
        homePage.typeOnPasswordInputForSignUp(PASSWORD);
        homePage.mouseOverSignUpForSignUpButtonIframe();
        homePage.clickOnSignUpForSignUpButtonIframe();
        homePage.exitIframe();
        homePage.waitForLogin();
        homePage.mouseOverUserIcon();

    }

    @When("I go to the Watch page")
    public void iGoToTheWatchPage(){
        Reporter.info("Going into watch page");

        watchPage = homePage.goToWatchPage();
    }

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

    @And("I should be able to return to the Home page")
    public void iShouldBeAbleToReturnToTheHomePage() {
        watchPage.returnToHomePage();
        Reporter.info("Verifying if I have returned to the Home page");
        Assert.assertTrue(homePage.userIconIsDisplayed(), "I returned to the Home page");
    }


    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        //homePage.waitForLogin();
        homePage.mouseOverUserIcon();
        Reporter.info("Verifying the account was created");
        Assert.assertEquals(homePage.verifyWelcomeText(), USER_WELCOME, "Account was created");

    }

    @When("I move the mouse over the User Icon")
    public void iMoveTheMouseOverTheUserIcon() {
        homePage.mouseOverUserIcon();
    }

    @Then("The welcome text is displayed and my name are displayed")
    public void theWelcomeTextIsDisplayedAndMyNameAreDisplayed() {
        Reporter.info("Verifying the welcome text is properly displayed with a name");
        Assert.assertEquals(homePage.verifyWelcomeText(), USER_WELCOME, "The welcome text is properly displayed with a name");
    }

    @When("I log out")
    public void iLogOut(){
        homePage.mouseOverUserIcon();
        homePage.clickOnLogout();

        
    }

    @Then("The welcome text is displayed without my name")
    public void theWelcomeTextIsDisplayedWithoutMyName(){
        Reporter.info("Verifying the welcome text is properly displayed without a name");
        homePage.refreshPage();

        homePage.mouseOverUserIcon();
        Assert.assertEquals(homePage.verifyWelcomeText(), "Welcome!", "The welcome text is properly displayed without a name");
    }
}
