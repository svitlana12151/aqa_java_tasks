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
        String phonenumb = phonetext.replaceAll("[^\\d]" ,"");
        System.out.print(phonenumb);
        driver.quit();
        }
}
