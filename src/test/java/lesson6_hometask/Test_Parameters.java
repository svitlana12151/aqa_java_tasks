package test.java.lesson6_hometask;

import main.java.lesson1.Task5;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test_Parameters {

    @Parameters({"str"})
    @Test
    private static void reverseMethodReturnsReversedString (@Optional("Goodbye") String str) {
        Task5 stringIsReversed = new Task5();
        String actualResult = stringIsReversed.reverse();
        String expectedString = "Hello World!!!";
        String expectedResult = new StringBuilder(expectedString).reverse().toString();
        assertEquals(actualResult, expectedResult);
    }
}
