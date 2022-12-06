package org.finalExamTae.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.HowToUseLocators;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.appium.java_client.pagefactory.LocatorGroupStrategy.ALL_POSSIBLE;

// TODO: Auto-generated Javadoc

/**
 * Map screen.
 *
 * @author Hans.Marquez
 */
public class MapScreen extends BaseScreen {

    /**
     * Constructor method.
     *
     * @param driver the driver
     * @author Hans.Marquez
     */
    public MapScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*categoryTitle\")")
    private AndroidElement categoryList;
    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*filterTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Filter\")")
    private AndroidElement filterButton;
    @HowToUseLocators(androidAutomation = ALL_POSSIBLE)
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*toggleTitle.*\")")
    @AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"Show List\")")
    private AndroidElement showListButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceIdMatches(\".*facilityTypeTitle\").textMatches(\"Hotels\")")
    private AndroidElement HotelsOption;
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/facilityTypeTitle\")")
    private List<AndroidElement> categoryOptions;

    /**
     * @author Hans.Marquez
     * return true if Category List element is displayed in screen, otherwise false.
     */
    public boolean isCategoryDisplayed() {
        return isElementAvailable(categoryList);
    }

    /**
     * @author Hans.Marquez
     * return true if Filter Button element is displayed in screen, otherwise false.
     */
    public boolean isFilterDisplayed() {
        return isElementAvailable(filterButton);
    }

    /**
     * @author Hans.Marquez
     * return true if Show List Button element is displayed in screen, otherwise false.
     */
    public boolean isShowListDisplayed() {
        return isElementAvailable(showListButton);
    }

    /**
     * verifies if the hotels option is displayed
     * @author jhon.dorado
     * @return true if the option is displayed, false otherwise
     */
    public boolean isShowHotelsOptionDisplayed() {
        if (this.isElementAvailable(categoryList, 5)) {
            click(categoryList);
        }

        return isElementAvailable(HotelsOption);
    }

    /**
     * verifies if all the option in the category list are correct
     * @return true if all the options are correct, false otherwise
     * @author jhon.dorado
     */
    public boolean verifyCategoryOptions() {
        List<String> expectedOptions = new ArrayList<>();
        List<Boolean> optionsFound = new ArrayList<>();
        Collections.addAll(expectedOptions, "Attractions", "Characters", "Dining", "Entertainment", "Restrooms", "Events and Tours", "PhotoPass", "Guest Services", "Shops", "Hotels", "Spa and Recreation");
        waitForVisibilityOfAllElements(categoryOptions);
        for (int i = 0; i < categoryOptions.size(); i++) {
            optionsFound.add(categoryOptions.get(i).getText().equals(expectedOptions.get(i)));
        }
        return !optionsFound.contains(false);
    }

    /**
     * clicks in the category list
     * @author jhon.dorado
     */
    public void clickCategoryList() {
        click(categoryList);
    }
}

