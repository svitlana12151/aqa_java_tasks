package test.java.lesson9_hometask.po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class NotebookPage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By producerEl = By.cssSelector("a>label[_ngcontent-c53]");
    private By acerFilter = By.cssSelector("[type='checkbox'][id='Acer']");
    private By producerFilter;

    public NotebookPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public NotebookPage applyProducerFilter() {
        WebElement filter = driver.findElement(acerFilter);
        wait.until(ExpectedConditions.elementToBeClickable(filter));
        filter.click();
        return this;
    }
}

