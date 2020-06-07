package test.java.hometaskAllure;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utils.PropertyLoader;

import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By uaLgSelector = By.cssSelector("[href='/ua/?gclid=Cj0KCQjwlN32BRCCARIsADZ-J4vs2ywuYkusr_Lz8rrVjvnofE6JQv9NpwybEbVGJMEEey_9TkLV2JMaAvPGEALw_wcB']");
    private final By leftmenuSelector = By.cssSelector("[class='menu-categories__link']");
    private final By compcatSelector = By.cssSelector("[class='tile-cats__heading tile-cats__heading_type_center']");
    Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    @Step("Open site")
    public HomePage getUrl() {
        logger.info("Navigate to site");
        driver.get(PropertyLoader.loadProperty("url"));
        return this;
    }

    @Step("Click Notebooks&Computers menu")
    public HomePage selectNotebookComputers(){
        wait.until(ExpectedConditions.elementToBeClickable(leftmenuSelector));
        List<WebElement> leftmenuLinks = driver.findElements(leftmenuSelector);
        logger.info("Click on left menu category");
        leftmenuLinks.get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(compcatSelector));
        return this;
    }

    @Step("Click Notebooks sub-menu")
    public HomePage clickNotebooks(){
        List<WebElement> compCateg = driver.findElements(compcatSelector);
        logger.info("Click on sub category");
            JavascriptExecutor executor = (JavascriptExecutor)driver; //to get element which is overlapped
            executor.executeScript("arguments[0].click();", compCateg.get(0));
        return this;
    }
}
