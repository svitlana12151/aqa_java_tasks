package test.java.lesson9_10_hometasks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class TestBaseSetup {
    WebDriver driver;

    @BeforeMethod
    @Parameters("browser")
    public void beforeMethod(String browser, ITestContext context) throws MalformedURLException{
        if (browser.equalsIgnoreCase("chrome")){
            ChromeOptions chOptions = new ChromeOptions();
            chOptions.addArguments("--disable notifications");
            chOptions.addArguments("--window-size=1300,1080");
            chOptions.addArguments("--lang=ua");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions ffOptions = new FirefoxOptions();
            ffOptions.addArguments("--disable notifications");
            ffOptions.addArguments("--window-size=1300,1080");
            ffOptions.addArguments("--lang=ua");
            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), ffOptions);
        }
        context.setAttribute("driver", driver);
    }


    @AfterMethod
    public void afterMethod(ITestResult result) {
        driver.quit();
    }
}
