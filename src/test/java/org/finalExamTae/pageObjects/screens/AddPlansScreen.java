package org.finalExamTae.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which contains all Add Plans screen elements and methods.
 */
public class AddPlansScreen extends BaseScreen {


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*actionSheetItemText\").textMatches(\"Check Dining Availability\")")
    private AndroidElement checkDiningAvailability;

    /**
     * Constructor method
     * @param driver AndroidDriver
     */
    public AddPlansScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    /**
     * verifies if the option Checking Dining Availability is displayed,
     * in the requirements is called "Reserve Dining Option"
     * @return true if the option is displayed, false otherwise
     */
    public boolean isCheckingDiningAvailabilityDisplayed() {
        return isElementAvailable(checkDiningAvailability);
    }
}
