package org.finalExamTae.tests.stepDefinitions.mobile;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.finalExamTae.configuration.mobile.MobileDriver;
import org.finalExamTae.utils.capabilities.ConfigCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Class for Mobile hooks.
 */
public class MobileHooks {

    private static MobileDriver driver;

    /**
     * Before hook for initializing the driver.
     */
    @Before
    public void environmentSetUp(Scenario scenario) {
        scenario.getSourceTagNames().stream().forEach(tag -> {
            if (tag.equals("@mobileAutomation")) {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                ConfigCapabilities.deviceSetUp(capabilities);
                ConfigCapabilities.applicationSetUp(capabilities);
                try {
                    driver = new MobileDriver(new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities));
                } catch (MalformedURLException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    /**
     * After hook for closing the app.
     */
    @After
    public void tearDown(Scenario scenario) {
        scenario.getSourceTagNames().stream().forEach(tag -> {
            if (tag.equals("@mobileAutomation")) {
                driver.getDriver().quit();
            }
        });

    }


    /**
     * Allow to get the current driver instance.
     *
     * @return Current AndroidDriver instance
     */
    public static AndroidDriver<AndroidElement> getDriver() {
        return driver.getDriver();
    }
}
