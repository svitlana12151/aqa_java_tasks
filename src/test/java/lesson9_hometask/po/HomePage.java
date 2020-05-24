package test.java.lesson9_hometask.po;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    private String searchStr;
    private String popupStrSelect = "[class='popup-css lang-switcher-popup sprite-side']";//описує елемент попап
    //private By goodTitles = By.cssSelector("[class='goods-tile__title']");
    private By search = By.cssSelector("[name='search']"); //обявляє елемент Search
    private By searchResultItem = By.xpath("//span[contains(text(), '" + searchStr + "')]"); // перевіряє чи знайдені елементи містять слово, яке шукали
    private By popup = By.cssSelector(popupStrSelect); //знаходить попап елемент
    private By popupClose = By.cssSelector(popupStrSelect + " [class='popup-close']");//описує елемент що закриває попап (знайди попап і в ньому закрий)
    private final By boldCategories = By.cssSelector("[class='m-cat-l-i-title rz-m-cat-l-i-title']");
    private final By leftMenuEl = By.cssSelector("[class='menu-categories__link']");


    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public HomePage open() {
        driver.get("https://rozetka.com.ua");
        return this;
    }

    public HomePage search(String searchStr) { //шукає елемент в пошуку і повертає введений елемент
        this.searchStr = searchStr;
        WebElement searchEl = driver.findElement(search);
        wait.until(ExpectedConditions.elementToBeClickable(searchEl)); //почекати, поки елемент в пошуку, який знайшовся, стане клікабельний
        if (driver.findElements(popup).size() > 0) {
            driver.findElement(popupClose).click(); //якщо є попап - то клікни на елементі, що його закриває
        }
        searchEl.sendKeys(this.searchStr);
        searchEl.sendKeys(Keys.ENTER);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //; //почекай, поки знайдуться всі елементи
        return this;
    }

    public List<WebElement> searchResultItems() {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(searchResultItem)));
        return driver.findElements(searchResultItem);
    }

    public List<WebElement> getBoldCategoriesOfGoods() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(boldCategories));
        return driver.findElements(boldCategories);
    }

    public HomePage openNotebooksPage(){
        driver.get("https://rozetka.com.ua/notebooks/c80004/filter/preset=workteaching/");
        return this;
    }
}