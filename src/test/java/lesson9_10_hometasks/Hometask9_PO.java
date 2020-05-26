package test.java.lesson9_10_hometasks;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.java.lesson9_10_hometasks.po.HomePage;

public class Hometask9_PO extends TestBaseSetup {
    HomePage homePage;

    @BeforeMethod
    public void initialize() {

        this.homePage = new HomePage(this.driver);
    }

    @Test
    public void onlyIphonesAreShownInResult() {
        this.homePage.open();
        this.homePage.search("iPhone");
        List<WebElement> goodsList = this.homePage.searchResultItems();
        Iterator var2 = goodsList.iterator();

        while(var2.hasNext()) {
            WebElement good = (WebElement)var2.next();
            String expectedGoodsName = "iphone";
            String actualGoodsName = good.getText().toLowerCase();
            Assert.assertTrue(
                    actualGoodsName.contains(expectedGoodsName),
                    "Elements of search result don't include expected goods name");
        }
    }

    @Test
    public void allTypesOfGoodsAreShown() {
        homePage.open().search("Samsung");
        List<WebElement> boldCategoriesList = homePage.getBoldCategoriesOfGoods();
        List<String> expectedListOfBoldCategories = Arrays.asList(
                "Смартфони, ТВ і електроніка",
                "Побутова техніка, інтер'єр",
                "Комп'ютери та ноутбуки",
                "Знижені в ціні товари",
                "Комплектуючі та аксесуари до електронних сигарет",
                "Спорт і захоплення",
                "Клейка стрічка, скотч, стрейч плівка",
                "Аксесуари для відеоспостереження",
                "Акумулятори та зарядні пристрої для інструменту і садової техніки");
        for(WebElement elOfBoldCatList: boldCategoriesList) {
            String actualElOfBoldCat = elOfBoldCatList.getText();
            Assert.assertTrue(
                    expectedListOfBoldCategories.contains(actualElOfBoldCat),
                    "Expected element " + expectedListOfBoldCategories + " should contain " + actualElOfBoldCat);
        }
    }
}
