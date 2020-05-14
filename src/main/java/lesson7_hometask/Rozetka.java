package main.java.lesson7_hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Rozetka {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/");

        String phonetext = driver.findElement(By.cssSelector("[class='link-dashed']")).getText();
        Thread.sleep(10000);

        String [] number = phonetext.split(" ");
        String numberFromBrackets= number[0].substring(phonetext.indexOf("(")+1, phonetext.indexOf(")"));
        String[] numberAfterBrackets = number[1].split("-");
        System.out.print(numberFromBrackets);
        for (String a: numberAfterBrackets)
            System.out.print(a);

        driver.quit();
        }
}
