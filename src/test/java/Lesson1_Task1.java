
import org.testng.annotations.Test;
import java.util.Arrays;

import static lesson1.Task1.min;
import static org.testng.Assert.assertEquals;

public class Lesson1_Task1 {
    @Test
    private void methodReturnsMinOfValues() {
        int [] arr = {5, 2, 3};
        Arrays.sort(arr);
        int expectedResult = arr[0];
        int actualResult =  min(5, 2, 3);
        assertEquals(actualResult, expectedResult, "Expected min of values is " + expectedResult + ", got " + actualResult);
    }
}
