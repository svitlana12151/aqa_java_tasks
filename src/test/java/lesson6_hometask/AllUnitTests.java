package test.java.lesson6_hometask;
import main.java.lesson1.Task1;
import main.java.lesson1.Task2;
import main.java.lesson1.Task5;
import org.testng.annotations.Test;
import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class AllUnitTests {

    @Test
    private static void methodReturnsMinOfValues(int a, int b, int c) {
        Task1 minElementOfArray = new Task1();
        int [] arr = {5, 2, 3};
        Arrays.sort(arr);
        int actualMinElementOfArray = minElementOfArray.minOfThreeValues(a, b, c);
        int expectedMinElementOfArray = arr[0];
        assertEquals(actualMinElementOfArray, expectedMinElementOfArray,
                "Expected min of values is " + expectedMinElementOfArray + ", got " + actualMinElementOfArray);
    }

    @Test
    private static void reverseMethodReturnsReversedString () {
        Task5 stringIsReversed = new Task5();
        String str = "Hello World!!!";
        String actualResult = stringIsReversed.reverse();
        String expectedResult = new StringBuilder(str).reverse().toString();
        assertEquals(actualResult, expectedResult);
    }

   @Test
    private static void matrixRowContainsTenElements() {
        Task2 matrix = new Task2();
        String actualMatrix[][] = matrix.printMatrixOfNames();
        int actualNumberOfElementsInRow = actualMatrix.length;
        int expectedNumberOfElementsInRow = 10;
        assertEquals(actualNumberOfElementsInRow, expectedNumberOfElementsInRow,
               "Expected number of elements in row is " + expectedNumberOfElementsInRow +
                       " but got " + actualNumberOfElementsInRow);
   }

    @Test
    private static void matrixColumnContainsFiveElements() {
        Task2 matrix = new Task2();
        String actualMatrix[][] = matrix.printMatrixOfNames();
        int actualNumberOfElementsInColumn = actualMatrix[0].length;
        int expectedNumberOfElementsInColumn = 5;
        assertEquals(actualNumberOfElementsInColumn, expectedNumberOfElementsInColumn,
                "Expected number of elements in column is " + expectedNumberOfElementsInColumn +
                " but got " + actualNumberOfElementsInColumn);
    }
}
