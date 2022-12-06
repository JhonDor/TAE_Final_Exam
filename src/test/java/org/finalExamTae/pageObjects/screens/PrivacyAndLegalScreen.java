package org.finalExamTae.pageObjects.screens;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrivacyAndLegalScreen extends BaseScreen {
    /**
     * Constructor method for standard screens object.
     *
     * @param driver : AndroidDriver
     * @author Arley.Bolivar, Hans.Marquez
     */
    public PrivacyAndLegalScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.disney.wdpro.dlr:id/txt_element\")")
    private List<AndroidElement> privacyAndLegalMenu;

    /**
     * verifies if of the options in the screen are correct
     * @return true if all the options are correct, false otherwise
     */
    public boolean PrivacyAndLegalOptions(){
        List<String> expectedOptions = new ArrayList<>();
        List <Boolean> correctOption = new ArrayList<>();
        Collections.addAll(expectedOptions, "Privacy Policy", "Terms of Use", "Supplemental Terms and Conditions","Legal Notices", "Property Rules", "Electronic Communications Disclosure", "Your California Privacy Rights", "Do Not Sell My Personal Information", "In-App Maps Subject to Google Terms and Conditions", "In-App Maps Subject to Google Privacy Policy");
        waitForVisibilityOfAllElements(privacyAndLegalMenu);
        for(int i = 0; i < privacyAndLegalMenu.size(); i++){
            correctOption.add(privacyAndLegalMenu.get(i).getText().equals(expectedOptions.get(i)));
        }
        return !correctOption.contains(false);
    }
}
