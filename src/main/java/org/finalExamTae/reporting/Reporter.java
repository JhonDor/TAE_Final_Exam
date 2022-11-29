package org.finalExamTae.reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * This class will be used for the reports instead of the default reporter
 */
public class Reporter {
    /**
     * Reporter constructor method.
     */
    public Reporter() {
    }

    /**
     * Return the logger, named corresponding to the class passed as parameter.
     * @return Logger
     */
    private static Logger getLogger() {
        return LoggerFactory.getLogger(Reporter.class);
    }

    /**
     * Print in the console any desired information by using the logger format as needed.
     * @param text Information to be printed
     */
    public static void info(String text) {
        getLogger().info(text);
    }

    /**
     * Print in the console any found error by using the logger format as needed.
     * @param text Error to be printed
     */
    public static void error(String text) {
        getLogger().error(text);
    }
}
