package org.finalExamTae.pageObjects.pages;

import org.finalExamTae.configuration.web.WebOperations;
import org.openqa.selenium.WebDriver;

public class BasePage extends WebOperations {
    /**
     * Constructor method.
     * @param driver WebDriver
     */
    public BasePage(WebDriver driver) {
        super(driver);
    }
}
