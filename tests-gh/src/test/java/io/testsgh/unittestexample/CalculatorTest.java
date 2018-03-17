package io.testsgh.unittestexample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testAdd() {
        int actualResult = calculator.add(1, 2);
        int expectedResult = 3;

        assertEquals(actualResult, expectedResult);
    }

}