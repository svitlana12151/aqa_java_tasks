package test.java.hometaskAllure;

import io.qameta.allure.Step;
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
    private String randProducer;

    private final By prodFilterEl = By.cssSelector("a>label[_ngcontent-c53]");
    private final By workteachFilter = By.xpath("//label[contains(text(),'Для роботи')]");
    private By filteredNotebook = By.cssSelector("[class='goods-tile__title']");
    Logger logger = LogManager.getLogger(NotebookPage.class);

    public NotebookPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10L);
    }

    @Step("Select universal notebook's category")
    public NotebookPage applyWorkteachingFilter() {
        wait.until(ExpectedConditions.elementToBeClickable(workteachFilter));
        WebElement universalFilter = driver.findElement(workteachFilter);
        universalFilter.click();
        logger.info("Apply workteaching filter");
        return this;
    }

    @Step("Generate random filter")
    public String getRandomProdFilter() {
        logger.info("Find filters");
        wait.until(ExpectedConditions.presenceOfElementLocated(prodFilterEl));
        List<WebElement> producerElFilters = driver.findElements(prodFilterEl);
        int max = producerElFilters.size();
        int rand = (int) (Math.random() * (max + 1));
        logger.info("Get random producer filter");
        return producerElFilters.get(rand).getAttribute("for");
    }

    @Step("Click on generated filter {randProducer}")
    public List<WebElement> applyProdFilter(String randProducer) throws InterruptedException {
        this.randProducer = randProducer;
        logger.info("Find filters");
        WebElement prodFilter = driver.findElement(By.cssSelector("[for='" + randProducer + "']"));
        wait.until(ExpectedConditions.elementToBeClickable(prodFilter));
        logger.info("Click on producer filter");
        prodFilter.click();
        wait.until(ExpectedConditions.titleContains(randProducer));
        return driver.findElements(filteredNotebook);
    }
}