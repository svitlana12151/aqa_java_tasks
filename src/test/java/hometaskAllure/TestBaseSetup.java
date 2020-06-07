package test.java.hometaskAllure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBaseSetup {
        WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions chOptions = new ChromeOptions();
        chOptions.addArguments("--disable notifications");
        chOptions.addArguments("--window-size=1300,1080");
        driver = new ChromeDriver(chOptions);
    }

    /*@AfterMethod
    public void afterMethod(ITestResult result) {
        driver.quit();
    }*/
}
