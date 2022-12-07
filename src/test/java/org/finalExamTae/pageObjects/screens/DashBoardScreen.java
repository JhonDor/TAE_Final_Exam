package org.finalExamTae.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


/**
 * DashBoard screen.
 *
 * @author Hans.Marquez
 */
public class DashBoardScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver : AndroidDriver
     * @author Hans.Marquez
     */
    public DashBoardScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"dismiss-icon\")")
    private AndroidElement dismissWelcome;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*android:id/button2\")")
    private AndroidElement dismissPreferenceUpdateButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon\").description(\"Map, Tab, 2of5\")")
    private AndroidElement mapButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_icon\").description(\"More Options, Tab, 5of5\")")
    private AndroidElement menuButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*tab_animated_icon\").description(\"Buy tickets, Reserve Dining, Tab, 3of5\")")
    private AndroidElement addPlansButton;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*actionSheetItemText\").textMatches(\"Check Dining Availability\")")
    private AndroidElement checkDiningAvailability;


    /**
     * This method dismisses all the alerts in the dashboard screen and click in one of the options
     * @param option in the android element you want to click
     * @author Hans.Marquez
     */
    public void navigateToOption(AndroidElement option) {
        if (super.isElementAvailable(this.dismissWelcome, 15)){
            click(this.dismissWelcome);
        }
        if (super.isElementAvailable(this.dismissPreferenceUpdateButton, 15)){
            click(this.dismissPreferenceUpdateButton);
        }
        click(option);
    }

    /**
     * Navigates to the map screen
     * @return a new map screen
     */
    public MapScreen goToMapScreen() {
        this.navigateToOption(this.mapButton);
        return new MapScreen(getDriver());
    }

    /**
     * Navigates to the menu screen
     * @return a new menu screen
     */
    public MenuScreen goToMenuScreen() {
        this.navigateToOption(this.menuButton);
        return new MenuScreen(getDriver());
    }

    public boolean isMenuButtonDisplayed(){
        return this.isElementAvailable(menuButton);
    }

    /**
     * verifies if the Add plans button is displayed
     * @return true if the button is displayed, false otherwise
     * @author jhon.dorado
     */

    public boolean isAddPlansButtonIsDisplayed() {
        return this.isElementAvailable(addPlansButton, 25);
    }

    /**
     * clicks in the Add plans button
     * @author jhon.dorado
     */
    public void clickAddPlansButton() {
        click(addPlansButton);
    }

    /**
     * verifies if the option "Checking Dining Availability is displayed, in the requirements is called "Reserve Dining Option"
     * @return true if the option is displayed, false otherwise
     * @author jhon.dorado
     */
    public boolean isCheckingDiningAvailabilityDisplayed() {
        return isElementAvailable(checkDiningAvailability);
    }

    /**
     * navigates to the main screen
     * @authos jhon.dorado
     */
    public void goToMainScreen() {
        if (this.isElementAvailable(dismissWelcome, 25)) {
            click(dismissWelcome);
        }

        if (this.isElementAvailable(dismissPreferenceUpdateButton, 35)) {
            click(dismissPreferenceUpdateButton);
        }
    }
    /**
     * navigates to add plans screen
     * @return a new add plans screen
     */
    public AddPlansScreen goToAddPlansScreen() {
        this.navigateToOption(this.addPlansButton);
        return new AddPlansScreen(getDriver());
    }
}



