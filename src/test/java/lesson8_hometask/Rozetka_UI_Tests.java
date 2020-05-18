package test.java.lesson8_hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.testng.Assert.*;

public class Rozetka_UI_Tests {
    WebDriver driver;
    String expectedRedBorderColorOfAllFields = ("rgb(248, 65, 71)");
    By loginToPersonalCabinet = By.cssSelector("[class='header-topline__user-link link-dashed']");
    By register = By.cssSelector("[class='auth-modal__register-link']");
    By name = By.cssSelector("[formcontrolname='name']");
    By username = By.cssSelector("[formcontrolname='username']");
    By password = By.cssSelector("[formcontrolname='password']");
    By submit = By.cssSelector("[type='submit']");

    @BeforeMethod
    public void beforeMethod() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.findElement(loginToPersonalCabinet).click();
        driver.findElement(register).click();
    }

    @Test
    public void allEmptyFieldsAreHighlightedInRed() {
        WebElement nameField = driver.findElement(name);
        nameField.click();
        WebElement usernameField = driver.findElement(username);
        usernameField.click();
        WebElement passwordField = driver.findElement(password);
        passwordField.click();
        driver.findElement(submit).click();

        String actualBorderColorOfNameField = nameField.getCssValue("border-color");
        assertEquals(actualBorderColorOfNameField, expectedRedBorderColorOfAllFields, "Name assert failed:");

        String actualBorderColorOfUsernameField = usernameField.getCssValue("border-color");
        assertEquals(actualBorderColorOfUsernameField, expectedRedBorderColorOfAllFields, "Username assert failed:");

        new WebDriverWait(driver, 10).until(presenceOfAllElementsLocatedBy(password));
        String actualBorderColorOfPasswordField = passwordField.getCssValue("border-color");
        assertEquals(actualBorderColorOfPasswordField, expectedRedBorderColorOfAllFields, "Password assert failed:");
    }

    @Test
    public void populatedFieldIsNotHihglightedInRed() {
        WebElement nameField = driver.findElement(name);
        nameField.sendKeys("Світлана");
        WebElement usernameField = driver.findElement(username);
        usernameField.click();
        WebElement passwordField = driver.findElement(password);
        passwordField.click();
        driver.findElement(submit).click();

        String actualBorderColorOfNameField = nameField.getCssValue("border-color");
        String expectedBorderColorOfNameField = "rgb(210, 210, 210)";
        assertEquals(actualBorderColorOfNameField, expectedBorderColorOfNameField);
        //assertFalse(actualBorderColorOfNameField.equals(expectedBorderColorOfAllFields), "Name assert failed:");

        String actualBorderColorOfUsernameField = usernameField.getCssValue("border-color");
        assertEquals(actualBorderColorOfUsernameField, expectedRedBorderColorOfAllFields, "Username assert failed:");

        new WebDriverWait(driver, 10).until(presenceOfAllElementsLocatedBy(password));
        String actualBorderColorOfPasswordField = passwordField.getCssValue("border-color");
        assertEquals(actualBorderColorOfPasswordField, expectedRedBorderColorOfAllFields, "Password assert failed:");
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }
}