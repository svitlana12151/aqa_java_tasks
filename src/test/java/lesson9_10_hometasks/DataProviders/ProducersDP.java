package test.java.lesson9_10_hometasks.DataProviders;

import org.openqa.selenium.By;
import org.testng.IAnnotationTransformer;
import org.testng.annotations.DataProvider;
import org.testng.annotations.IConfigurationAnnotation;
import org.testng.annotations.ITestAnnotation;
import test.java.utils.RetryAnalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ProducersDP{

    @DataProvider(
            name = "Producers"
    )
    public Object[][] getData() {
        return new Object[][]{
                {By.cssSelector("label[for='Acer']"), "acer"},
                {By.cssSelector("label[for='Apple']"), "apple"}};
                /*{By.cssSelector("label[for='Asus']"), "asus"},
                {By.cssSelector("label[for='Dell']"), "dell"},
                {By.cssSelector("label[for='Dream Machines']"), "dream machines"},
                {By.cssSelector("label[for='HP']"), "hр"},
                {By.cssSelector("label[for='Lenovo']"), "lenovo"},
                {By.cssSelector("label[for='MSI']"), "msi"},
                {By.cssSelector("label[for='Microsoft']"), "microsoft"},
                {By.cssSelector("label[for='Razer']"), "razer"},
                {By.cssSelector("label[for='Xiaomi']"), "xiaomi"},
                {By.cssSelector("label[for='Google']"), "google"},
                {By.cssSelector("label[for='Vinga']"), "vinga"},
                {By.cssSelector("label[for='Yepo']"), "yepo"}};*/
    }
}
