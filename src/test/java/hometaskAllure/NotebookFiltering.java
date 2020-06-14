package test.java.hometaskAllure;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

@Epic("Check Filters")
public class NotebookFiltering extends TestBaseSetup{
    HomePage homePage;
    NotebookPage notebookPage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
        notebookPage = new NotebookPage(driver);
    }

    @Feature("Test producer filter")
    @Test
    public void applyRandomProducerfilter() throws InterruptedException {
        homePage
                .getUrl()
                .selectNotebookComputers()
                .clickNotebooks();
        notebookPage
                .applyWorkteachingFilter()
                .getRandomProdFilter();
        String expectedFilter = notebookPage.getRandomProdFilter();
        List<WebElement>notebooksList = notebookPage.applyProdFilter(expectedFilter);
        for (WebElement notebook : notebooksList) {
            String actualProducer = notebook.getText();
            Assert.assertTrue(actualProducer.contains(expectedFilter),
                    "Expected producer of notebooks filter is: " + expectedFilter + " but found " + actualProducer);
            break;
        }
    }
}
