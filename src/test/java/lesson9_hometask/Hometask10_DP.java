package test.java.lesson9_hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.java.lesson9_hometask.po.HomePage;
import test.java.lesson9_hometask.po.NotebookPage;

public class Hometask10_DP extends TestBaseSetup {
    HomePage homePage;
    NotebookPage notebookPage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }

    @Test
    public void selectedProducerIsApplied() {
        homePage.openNotebooksPage();
        notebookPage.applyProducerFilter();

    }
}
