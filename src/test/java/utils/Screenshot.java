package test.java.utils;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Screenshot {
    private final WebDriver driver;

    public Screenshot(WebDriver driver) {
        this.driver = driver;
    }

    public void getScreenshot(ITestResult testResult) {
        TakesScreenshot screenshot = (TakesScreenshot)this.driver;
        File src = (File)screenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src, new File("screenshot\\\\"
                    + testResult.getTestClass().getName().replace(".", "\\\\")
                    + "\\\\"
                    + testResult.getMethod().getConstructorOrMethod().getName()
                    + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
