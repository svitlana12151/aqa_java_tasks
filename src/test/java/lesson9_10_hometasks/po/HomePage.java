package test.java.lesson9_10_hometasks.po;

import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utils.PropertyLoader;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String searchStr;
    String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";
    By search = By.cssSelector("[name='search']");
    //By searchResultItem = By.xpath("//span[contains(text(), '" + searchStr + "')]");
    private By popup = By.cssSelector(popupStrSelect);
    private By popupClose = By.cssSelector(popupStrSelect + " [class='popup-close']");
    private By boldCategories = By.cssSelector("[class='m-cat-l-i-title rz-m-cat-l-i-title']");
    private By searchedGoods = By.xpath ("//div[@class = 'goods-tile__inner']");
    Logger logger = LogManager.getLogger(HomePage.class);

    public HomePage(WebDriver driver) {
        logger.debug("initialize");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10L);
    }

    public HomePage open() {
        logger.info("Open");
        driver.get(PropertyLoader.loadProperty("url"));
        logger.debug("URL: " + this.driver.getCurrentUrl());
        return this;
    }

    public HomePage search(String searchStr) {
        logger.info("Find 'Search' field");
        this.searchStr = searchStr;
        WebElement searchEl = driver.findElement(search);
        this.wait.until(ExpectedConditions.elementToBeClickable(searchEl));
        if (driver.findElements(popup).size() > 0) {
            logger.info("close popup");
            driver.findElement(popupClose).click();
        }
        logger.info("Enter element to search");
        searchEl.sendKeys(this.searchStr);
        logger.info("Click enter");
        searchEl.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public List<WebElement> searchResultItems() {
        logger.info("Show searched elements");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchedGoods));
        return driver.findElements(searchedGoods);
    }

    public List<WebElement> getBoldCategoriesOfGoods() {
        logger.info("Find bold categories on left menu");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(boldCategories));
        return driver.findElements(boldCategories);
    }
}