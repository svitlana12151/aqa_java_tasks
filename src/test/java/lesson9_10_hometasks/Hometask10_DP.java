package test.java.lesson9_10_hometasks;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.lesson9_10_hometasks.po.NotebookPage;

public class Hometask10_DP extends TestBaseSetup {
    NotebookPage notebookPage;

    @BeforeMethod
    public void initialize() {
        notebookPage = new NotebookPage(driver);
    }

    @Test(/*dataProvider = "Producers", dataProviderClass = ProducersDataProvider.class*/)
    public void selectedProducerIsApplied(By producerFilter, String expectedProducer) {
        notebookPage.openNotebooksPage();
        notebookPage.applyProducerFilter(producerFilter);
        List<WebElement> listOfFilteredNotebooks = notebookPage.getListOfFilteredNotebooks(expectedProducer);
        for(WebElement notebookTitle: listOfFilteredNotebooks) {
            String actualNotebookTitle = notebookTitle.getText().toLowerCase();
            Assert.assertTrue(
                    actualNotebookTitle.contains(expectedProducer),
                    "Expected goods producer is " + expectedProducer + " but found " + actualNotebookTitle);
        }
    }
}

