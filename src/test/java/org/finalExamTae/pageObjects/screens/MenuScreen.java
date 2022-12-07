package org.finalExamTae.pageObjects.screens;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MenuScreen extends BaseScreen {
    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public MenuScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/content\")")
    private List<AndroidElement> menuOptions;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*content\").textMatches(\"Privacy & Legal\")")
    private AndroidElement privacyAndLegalOption;

    /**
     * verifies if all the options in the menu options are correct
     * @return true if all the options are correct, false otherwise
     */
    public boolean checkMenuOptions() {
        List<String> expectedOptions = new ArrayList<>();
        List<Boolean> correctOption = new ArrayList<>();
        Collections.addAll(expectedOptions, "My Profile",
                "Property Rules",
                "Cast Compliment",
                "Link to Account",
                "Car Locator",
                "Help",
                "Privacy & Legal");
        waitForVisibilityOfAllElements(menuOptions);
        for (int i = 0; i < menuOptions.size(); i++) {
            correctOption.add(menuOptions.get(i).getText().equals(expectedOptions.get(i)));
        }
        return !correctOption.contains(false);
    }

    /**
     * scrolls until the amount of swipes has been completed
     * @param locator is the selector that indicates to keep scrolling
     * @param swipes is the maximum amount of swipes the method will do
     */
    public void scroll(String locator, int swipes) {
        int swipesAmount = 0;
        while (swipesAmount < swipes) {
            try {
                getDriver().findElementByAndroidUIAutomator(locator);
                swipesAmount++;
            } catch (Exception e) {
                swipesAmount++;
            }
        }
    }

    /**
     * scroll to the bottom of the page
     * @param swipes the amount of swipes given to the scroll method
     */
    public void scrollDown(int swipes) {
        String locator = "new UiScrollable(.scrollable(true)).scrollToEnd(1)";
        scroll(locator, swipes);
    }

    /**
     * navigates to the PrivacyAndLegal screen
     * @return a new PrivacyAndLegal screen
     */
    public PrivacyAndLegalScreen goToPrivacyAndLegalScreen() {
        click(privacyAndLegalOption);
        return new PrivacyAndLegalScreen(getDriver());
    }
}