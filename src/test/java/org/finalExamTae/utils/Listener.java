package org.finalExamTae.utils;

import org.finalExamTae.reporting.Reporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;


public class Listener implements ITestListener {
    /**
     * Prints a message when a test starts.
     *
     * @param result Current test
     */
    @Override
    public void onTestStart(ITestResult result) {
        Reporter.info("Starting test: " + result.getName());
    }


    /**
     * Prints a message when a test passes.
     *
     * @param result Current test
     */
    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.info("Test: " + result.getName() + " [PASSED]");
        System.out.println();
    }

    /**
     * Prints a message when a test fails.
     *
     * @param result Current test
     */
    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.error("Test: " + result.getName() + " [FAILED]");
        System.out.println();
    }

    /**
     * Default method from ITestListener
     */
    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    /**
     * Default method from ITestListener
     */
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    /**
     * Default method from ITestListener
     */
    @Override
    public void onStart(ITestContext iTestContext) {

    }

    /**
     * Default method from ITestListener
     */
    @Override
    public void onFinish(ITestContext iTestContext) {

    }
}
