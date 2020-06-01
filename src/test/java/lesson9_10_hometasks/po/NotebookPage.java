package test.java.lesson9_10_hometasks.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.java.utils.PropertyLoader;

import java.util.List;

public class NotebookPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    Logger logger = LogManager.getLogger(NotebookPage.class);
    private By filteredNotebook = By.cssSelector("[class='goods-tile__title']");

    public NotebookPage(WebDriver driver) {
        logger.debug("Initialize");
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10L);
    }

    public NotebookPage openNotebooksPage() {
        logger.info("Open");
        driver.get(PropertyLoader.loadProperty("notebookurl"));
        logger.debug("URL: " + driver.getCurrentUrl());
        return this;
    }

    public NotebookPage applyProducerFilter(By producerFilter) {
        logger.info("Apply filter");
        wait.until(ExpectedConditions.elementToBeClickable(producerFilter));
        driver.findElement(producerFilter).click();
        logger.debug("Show filtered notebooks");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(filteredNotebook));
        return this;
    }

    public List<WebElement> getListOfFilteredNotebooks(String expectedProducer) {
        logger.info("Get list of filtered notebooks");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(filteredNotebook));
        return driver.findElements(filteredNotebook);
    }
}
