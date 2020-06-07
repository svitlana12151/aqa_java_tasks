package test.java.utils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.*;

public class Listener implements
    ISuiteListener,
    ITestListener,
    IInvokedMethodListener{
    Logger logger = LogManager.getLogger(Listener.class);

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void onStart(ISuite suite) {

    }

    @Override
    public void onFinish(ISuite suite) {

    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.info("Test failed");
        Screenshot screenshot = new Screenshot((WebDriver) result.getTestContext().getAttribute("driver"));
        screenshot.getScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        logger.trace("Test failed within success persentage");
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

    }
}
