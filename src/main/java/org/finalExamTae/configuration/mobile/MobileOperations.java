package org.finalExamTae.configuration.mobile;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * Class for defining all common operations in the mobile tests
 */
public abstract class MobileOperations {

    private final AndroidDriver<AndroidElement> driver;
    private final WebDriverWait wait;
    private final long waitDuration = 10L;

    /**
     * this is the constructor method.
     */
    public MobileOperations(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, waitDuration);
        initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(0)), this);
    }

    /**
     * this method helps to get the WebDriver.
     *
     * @return WebDriver
     */
    public AndroidDriver<AndroidElement> getDriver() {
        return this.driver;
    }

    /**
     * Swipe vertical for scrolling down in the screen.
     */
    public void swipeVertical() {
        Dimension windowSize = this.getDriver().manage().window().getSize();
        int x = windowSize.getWidth() / 2;
        int y = windowSize.getHeight() / 2;
        int edgeBorder = 10;
        TouchAction action = new TouchAction(this.getDriver());
        action.press(PointOption.point(x, y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                .moveTo(PointOption.point(x, edgeBorder))
                .release()
                .perform();
    }

    /**
     * method to click elements
     *
     * @param element AndroidElement
     */
    public void click(AndroidElement element) {
        this.waitForVisibility(element);
        element.click();
    }

    /**
     * Verifies if a given android element is visible
     *
     * @param element the android element you want to verify
     * @return true if the given android element is visible, false otherwise
     */
    public boolean isElementAvailable(AndroidElement element) {
        try {
            this.waitForVisibility(element);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Verifies if an android element is visible after a custom period of time in seconds
     *
     * @param element the android element you want to verify
     * @param timeout the amount of seconds to wait
     * @return true if the given android element is visible, false otherwise
     */
    public boolean isElementAvailable(AndroidElement element, long timeout) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        try {
            this.waitForVisibility(element, wait);
            return true;
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    /**
     * Waits for an element to be visible, 10 seconds is the default time
     *
     * @param element the given android element
     */
    public void waitForVisibility(AndroidElement element) {
        this.wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for an element to be visible during a custom period of time (in seconds).
     *
     * @param element AndroidElement
     * @param wait    WebDriverWait
     */
    public void waitForVisibility(AndroidElement element, WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for a list of elements to be visible
     *
     * @param elements the list of elements
     */
    public void waitForVisibilityOfAllElements(List<AndroidElement> elements) {
        elements.stream().forEach(element -> {
            this.waitForVisibility(element);
        });
    }
}
