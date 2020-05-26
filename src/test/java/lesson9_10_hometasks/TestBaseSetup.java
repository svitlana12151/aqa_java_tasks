package test.java.lesson9_10_hometasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import test.java.utils.Screenshot;

public class TestBaseSetup {
    WebDriver driver;
    WebDriverWait wait;
    Screenshot screenshot;

    public TestBaseSetup() {
    }

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--disable-notifications"});
        options.addArguments(new String[]{"--window-size=1300,1080"});
        this.driver = new ChromeDriver();
        this.screenshot = new Screenshot(this.driver);
    }

    @DataProvider(
            name = "Producers"
    )
    public Object[][] getData() {
        return new Object[][]{
                {By.cssSelector("label[for='Acer']"), "acer"},
                {By.cssSelector("label[for='Apple']"), "apple"},
                {By.cssSelector("label[for='Asus']"), "asus"},
                {By.cssSelector("label[for='Dell']"), "dell"},
                {By.cssSelector("label[for='Dream Machines']"), "dream machines"},
                {By.cssSelector("label[for='HP']"), "hp"},
                {By.cssSelector("label[for='Lenovo']"), "lenovo"},
                {By.cssSelector("label[for='MSI']"), "msi"},
                {By.cssSelector("label[for='Microsoft']"), "microsoft"},
                {By.cssSelector("label[for='Razer']"), "razer"},
                {By.cssSelector("label[for='Xiaomi']"), "xiaomi"},
                {By.cssSelector("label[for='Alien']"), "alien"},
                {By.cssSelector("label[for='Chuwi']"), "chuwi"},
                {By.cssSelector("label[for='Digma']"), "digma"},
                {By.cssSelector("label[for='Durabook']"), "durabook"},
                {By.cssSelector("label[for='Epic']"), "epic"},
                {By.cssSelector("label[for='Fujitsu']"), "fujitsu"},
                {By.cssSelector("label[for='Fujitsu-siemens']"), "fujitsu-siemens"},
                {By.cssSelector("label[for='Gigabyte']"), "gigabyte"},
                {By.cssSelector("label[for='Google']"), "google"},
                {By.cssSelector("label[for='Jumper']"), "jumper"},
                {By.cssSelector("label[for='Mediacon']"), "mediacon"},
                {By.cssSelector("label[for='Medion']"), "medion"},
                {By.cssSelector("label[for='Mixzo']"), "mixzo"},
                {By.cssSelector("label[for='Odys']"), "odys"},
                {By.cssSelector("label[for='Panasonic']"), "panasonic"},
                {By.cssSelector("label[for='Porsche Design']"), "porsche design"},
                {By.cssSelector("label[for='Prestigio']"), "prestigio"},
                {By.cssSelector("label[for='RCA']"), "rca"},
                {By.cssSelector("label[for='Teclast']"), "teclast"},
                {By.cssSelector("label[for='Vinga']"), "vinga"},
                {By.cssSelector("label[for='XMG']"), "xmg"},
                {By.cssSelector("label[for='Yepo']"), "yepo"}};
    }

    @AfterMethod
    public void afterMethod(ITestResult result) {
        this.screenshot.getScreenshot(result);
        this.driver.quit();
    }
}
