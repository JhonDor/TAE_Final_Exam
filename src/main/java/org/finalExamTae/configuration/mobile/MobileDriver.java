package org.finalExamTae.configuration.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * Class for the Mobile Driver.
 */
public class MobileDriver {
    private final AndroidDriver<AndroidElement> driver;

    /**
     * Constructor method.
     */
    public MobileDriver(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
    }

    /**
     * Allows to get the WebDriver.
     * @return WebDriver
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }
}
