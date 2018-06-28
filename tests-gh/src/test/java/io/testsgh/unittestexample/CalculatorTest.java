package io.testsgh.unittestexample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @DataProvider(name = "addParameters")
    public static Object[][] addParameters() {
        return new Object[][]{
                {1, 2, 3},
                {-1, 2, 1},
        };
    }

    @Test(dataProvider = "addParameters")
    public void testAdd(int x, int y, int expectedResult) {
        int actualResult = calculator.add(x, y);

        assertEquals(actualResult, expectedResult);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSqrt_fail() {
        calculator.sqrt(-1);
    }
}