package test.java.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
    private int currentCount = 1;
    private int runMax = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (currentCount < runMax) {
            currentCount++;
            return true;
        }
        return false;
    }
}
