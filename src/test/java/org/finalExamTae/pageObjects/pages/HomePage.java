package org.finalExamTae.pageObjects.pages;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Random;

public class HomePage extends BasePage {
    @FindBy(css = ".promo-banner-container iframe")
    private WebElement iframeBanner;

    @FindBy(css = "section.PromoBanner")
    private WebElement banner;

    @FindBy(css = "div.PromoBanner__CloseBtn")
    private WebElement bannerCloseButton;

    @FindBy(id = "global-user-trigger")
    private WebElement userIcon;

    @FindBy(id = "sideLogin-left-rail")
    private WebElement loginBox;

    @FindBy(css = "li.user > div.global-user:last-child")
    private WebElement userOptionsContainer;

    @FindBy(css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement loginOption;

    @FindBy(css = "div.global-user:last-child ul.account-management > li:last-child > a")
    private WebElement logOutLink;

    @FindBy(id = "oneid-iframe")
    private WebElement loginIframe;

    @FindBy(css = "div.view-starry-night > div:first-child")
    private WebElement loginModalIframe;

    @FindBy(id = "logo")
    private WebElement espnLogo;

    @FindBy(id = "InputLoginValue")
    private WebElement emailInput;

    @FindBy(id = "InputPassword")
    private WebElement passwordInput;

    @FindBy(css = "h2#Title span")
    private WebElement signUpTitleIframe;

    @FindBy(id = "InputFirstName")
    private WebElement firstNameInputIframe;

    @FindBy(id = "InputLastName")
    private WebElement lastNameInputIframe;

    @FindBy(id = "InputEmail")
    private WebElement emailForSignUpInputIframe;

    @FindBy(id = "password-new")
    private WebElement passwordForSignUpInputIframe;

    @FindBy(id = "BtnSubmit")
    private WebElement loginButtonIframe;

    @FindBy(id = "BtnCreateAccount")
    private WebElement signUpButtonIframe;

    @FindBy(id = "BtnSubmit")
    private WebElement signUpButtonForSignUpIframe;

    @FindBy(id = "close")
    private WebElement closeIframeButton;

    @FindBy(css = "li.pillar.watch > a")
    private WebElement watchButton;

    @FindBy(css = "div.global-user:last-child ul.account-management li.display-user")
    private WebElement welcomeText;

    /**
     * Constructor method
     *
     * @param driver WebDriver
     */
    public HomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Allows to verify if the promo banner in the 'Home' page is displayed.
     *
     * @return true if the promo banner is displayed, otherwise false
     */
    public boolean verifyPromoIframe() {
        boolean isBanner = true;
        try {
            super.waitForPresenceOfElement(".promo-banner-container iframe");
        } catch (TimeoutException e) {
            isBanner = false;
        }
        return isBanner;
    }

    /**
     * verifies if the User icon is displayed.
     *
     * @return true if the User icon is displayed, false otherwise
     */
    public boolean userIconIsDisplayed() {
        super.waitForVisibility(this.userIcon);
        return this.userIcon.isDisplayed();
    }

    /**
     * does a mouse over on the User icon.
     */
    public void mouseOverUserIcon() {
        super.waitForVisibility(this.userIcon);
        super.mouseOver(this.userIcon);
        //super.waitForVisibility(this.userOptionsContainer);
    }

    public void waitLogin() {
        super.waitForVisibility(this.userIcon);
    }

    /**
     * Allows to click on the Login option.
     */
    public void clickOnLoginOption() {
        super.clickElement(this.loginOption);
    }

    /**
     * Allows to switch to the iframe.
     */
    public void switchToIframe() {
        super.getDriver().switchTo().frame(this.loginIframe);
    }

    /**
     * Allows exit the iframe
     */
    public void exitIframe() {
        super.getDriver().switchTo().defaultContent();
    }

    /**
     * Verifies if the login modal is displayed
     *
     * @return true if the login modal is displayed, otherwise false
     */
    public boolean loginModalIsDisplayed() {
        super.waitForVisibility(this.loginModalIframe);
        return this.loginModalIframe.isDisplayed();
    }

    /**
     * Verifies if the ESPN logo is displayed
     *
     * @return true if the ESPN logo is displayed, false otherwise
     */
    public boolean espnLogoIsDisplayed() {
        super.waitForVisibility(this.espnLogo);
        return this.espnLogo.isDisplayed();
    }

    /**
     * Verifies if the login button is displayed
     *
     * @return true if the login button in the Login modal is displayed, false otherwise
     */
    public boolean loginButtonIsDisplayed() {
        super.waitForVisibility(this.loginButtonIframe);
        return this.loginButtonIframe.isDisplayed();
    }

    /**
     * Verifies if the sign-Up button is displayed
     *
     * @return true if the sign-Up button is displayed, false otherwise
     */
    public boolean signUpButtonIsDisplayed() {
        super.waitForVisibility(this.signUpButtonIframe);
        return this.signUpButtonIframe.isDisplayed();
    }

    /**
     * Helps to write a string in the email input
     *
     * @param text String
     */
    public void typeOnEmailInput(String text) {
        super.waitForVisibility(this.emailInput);
        super.typeOnInput(this.emailInput, text);
    }

    /**
     * Helps to write a String in the password input
     *
     * @param text String
     */
    public void typeOnPasswordInput(String text) {
        super.waitForVisibility(this.passwordInput);
        super.typeOnInput(this.passwordInput, text);
    }

    /**
     * Verifies if the title is displayed.
     *
     * @return true if the Title in the sign-Up modal is displayed, false otherwise
     */
    public boolean signUPTitleIsDisplayed() {
        super.waitForVisibility(this.signUpTitleIframe);
        return this.signUpTitleIframe.isDisplayed();
    }

    /**
     * Verifies if the first name input is displayed.
     *
     * @return true if the first name input is displayed, false otherwise
     */
    public boolean firstNameInputIsDisplayed() {
        super.waitForVisibility(this.firstNameInputIframe);
        return this.firstNameInputIframe.isDisplayed();
    }

    /**
     * Verifies if the last name input is displayed.
     *
     * @return true if the last name input is displayed, false otherwise
     */
    public boolean lastNameInputIsDisplayed() {
        super.waitForVisibility(this.lastNameInputIframe);
        return this.lastNameInputIframe.isDisplayed();
    }

    /**
     * Verifies if the email input is displayed.
     *
     * @return true if the email input is displayed, false otherwise
     */
    public boolean emailInputForSignUpIsDisplayed() {
        super.waitForVisibility(this.emailForSignUpInputIframe);
        return this.emailForSignUpInputIframe.isDisplayed();
    }

    /**
     * Verifies if the password input is displayed.
     *
     * @return true if the password input is displayed, otherwise false
     */
    public boolean passwordInputForSignUpIsDisplayed() {
        super.waitForVisibility(this.passwordForSignUpInputIframe);
        return this.passwordForSignUpInputIframe.isDisplayed();
    }

    /**
     * Verifies if the sign-up button is displayed.
     *
     * @return true if the sign-up button is displayed, false otherwise
     */
    public boolean signUpButtonForSignUpIsDisplayed() {
        super.waitForVisibility(this.signUpButtonForSignUpIframe);
        return this.signUpButtonForSignUpIframe.isDisplayed();
    }

    /**
     * Verifies if the close button in the sign-up is displayed.
     *
     * @return true if the close button is displayed, false otherwise
     */
    public boolean closeIframeButtonIsDisplayed() {
        super.waitForVisibility(this.closeIframeButton);
        return this.closeIframeButton.isDisplayed();
    }

    /**
     * Allows to write a given String in the First Name input located in the Sign-Up modal.
     *
     * @param text String
     */
    public void typeOnFirstNameInput(String text) {
        super.waitForVisibility(this.firstNameInputIframe);
        super.typeOnInput(this.firstNameInputIframe, text);
    }

    /**
     * Allows to write a given String in the Last Name input located in the Sign-Up modal.
     *
     * @param text String
     */
    public void typeOnLastNameInput(String text) {
        super.waitForVisibility(this.lastNameInputIframe);
        super.typeOnInput(this.lastNameInputIframe, text);
    }

    /**
     * Allows to write a given String in the Email input located in the Sign-Up modal.
     *
     * @param text String
     */
    public void typeOnEmailInputForSignUp(String text) {
        super.waitForVisibility(this.emailForSignUpInputIframe);
        super.typeOnInput(this.emailForSignUpInputIframe, text);
    }

    /**
     * Allows to write a given String in the Password input located in the Sign-Up modal.
     *
     * @param text String
     */
    public void typeOnPasswordInputForSignUp(String text) {
        super.waitForVisibility(this.passwordForSignUpInputIframe);
        super.typeOnInput(this.passwordForSignUpInputIframe, text);
    }

    /**
     * Allows to click on the Login button located in the Login modal.
     */
    public void clickOnLoginButtonIframe() {
        super.clickElement(this.loginButtonIframe);
    }

    /**
     * Allows to click on the Sign-Up button located in the Login modal.
     */
    public void clickOnSignUpButtonIframe() {
        super.clickElement(this.signUpButtonIframe);
    }

    /**
     * Allows to click on the Sign-Up button located in the Sign-Up modal.
     */
    public void clickOnSignUpForSignUpButtonIframe() {
        super.clickElement(this.signUpButtonForSignUpIframe);
    }

    /**
     * Allows to move the mouse over the Sign-Up button located in the Sign-Up modal.
     */
    public void mouseOverSignUpForSignUpButtonIframe() {
        super.mouseOver(this.signUpButtonForSignUpIframe);
    }


    /**
     * Allow to generate a random email for the Sign-Up procedure.
     *
     * @return an email in string form
     */
    public String createEmail() {
        String SaltChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) {
            int index = (int) (rnd.nextFloat() * SaltChars.length());
            salt.append(SaltChars.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr + "@gmail.com";
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    /**
     * clicks on the Logout option.
     */
    public void clickOnLogout() {
        super.clickElement(this.logOutLink);
    }

    /**
     * Allows to click on the Watch link in the 'Home' page for navigating to the 'Watch' page.
     *
     * @return
     */
    public WatchPage goToWatchPage() {
        super.waitForClickable(watchButton);
        super.clickElement(this.watchButton);
        return new WatchPage(getDriver());
    }


    public void waitForLogin() {
        super.waitForInvisibility(loginIframe);
    }

    public void waitForUserIcon() {
        super.waitForVisibility(userIcon);
    }


    /**
     * Gets the Welcome text, which os displayed while performing a mouse over action on the User icon.
     *
     * @return String
     */
    public String verifyWelcomeText() {
        super.waitForVisibility(this.welcomeText);
        return this.welcomeText.getText();
    }


    /**
     * Performs all needed steps for logging in.
     *
     * @param email    String
     * @param password String
     */
    public void generalLoginProcedure(String email, String password) {
        this.mouseOverUserIcon();
        this.clickOnLoginOption();
        this.switchToIframe();
        this.typeOnEmailInput(email);
        this.typeOnPasswordInput(password);
        this.clickOnLoginButtonIframe();
        this.exitIframe();
    }
}
