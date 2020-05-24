package test.java.lesson9_hometask;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.lesson9_hometask.po.HomePage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Hometask9_PO extends TestBaseSetup {
    HomePage homePage;

    @BeforeMethod
    public void initialize() {
        homePage = new HomePage(driver);
    }

    @Test
    public void onlyIphonesAreShownInResult() {
        homePage.open();
        homePage.search("iPhone");
        List<WebElement> goodsList = homePage.searchResultItems();

        for (WebElement good : goodsList) {
            String expectedGoodsName = "iphone";
            String actualGoodsName = good.getText().toLowerCase();
            assertTrue(actualGoodsName.contains(expectedGoodsName), "Elements of search result don't include expected goods name");
        }
    }

    @Test
    public void allTypesOfGoodsAreShown() {
        homePage.open();
        homePage.search("Samsung");
        List<WebElement> boldCategoriesList = homePage.getBoldCategoriesOfGoods();
        String[] expectedListOfBoldCategories = {"Смартфони, ТВ і електроніка",
                "Побутова техніка, інтер'єр",
                "Комп'ютери та ноутбуки",
                "Знижені в ціні товари",
                "Комплектуючі та аксесуари до електронних сигарет",
                "Спорт і захоплення",
                "Клейка стрічка, скотч, стрейч плівка",
                "Аксесуари для відеоспостереження",
                "Акумулятори та зарядні пристрої для інструменту і садової техніки"};
        for (String expectedEl : expectedListOfBoldCategories) {
            for (WebElement elOfBoldCatList : boldCategoriesList) {
                String actuaElOfBoldCat = elOfBoldCatList.getText();
                assertTrue(expectedEl.contains(actuaElOfBoldCat), "Expected element " + expectedEl + " should contain " + actuaElOfBoldCat);
            }
        }
    }
}
