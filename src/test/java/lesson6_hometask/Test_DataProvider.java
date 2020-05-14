package test.java.lesson6_hometask;

import main.java.lesson1.Task1;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test_DataProvider {
 Task1 minOfValues;

    @BeforeMethod
    public void beforeMethod(){
        minOfValues = new Task1();
    }

    @Test(dataProvider="forTask1")       //параметризація через дата провайдера
    private void methodReturnsMinOfValues(int a, int b, int c) {
        Task1 minElementOfArray = new Task1();
        int actualMinElementOfArray = minElementOfArray.minOfThreeValues(a, b, c);
        int expectedMinElementOfArray = 2;
        assertEquals(actualMinElementOfArray, expectedMinElementOfArray,
                "Expected min of values is " + expectedMinElementOfArray + ", got " + actualMinElementOfArray);
    }

    @DataProvider(name = "forTask1")
    public Object[][] getData() {
        return new Object[][]{
                {5, 2, 3}
        };
    }
}
