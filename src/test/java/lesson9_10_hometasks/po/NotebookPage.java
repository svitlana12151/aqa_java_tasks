package test.java.lesson9_10_hometasks.po;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
        logger.info("Navigate to notebooks page");
        logger.warn("Navigate to notebooks page");
        logger.error("Navigate to notebooks page");
        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/preset=workteaching/");
        return this;
    }

    public NotebookPage applyProducerFilter(By producerFilter) {
        logger.info("Apply filter");
        wait.until(ExpectedConditions.presenceOfElementLocated(producerFilter));
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
