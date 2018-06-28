package io.testsgh.unittestexample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.testng.Assert.assertEquals;

public class CalculatorSpyTest {

    private CalculatorWithOperations calculator;

    @BeforeMethod
    public void setUp() {
        calculator = spy(
                new CalculatorWithOperations(
                        Number::doubleValue,
                        (f, s) -> f
                )
        );
    }

    @Test
    public void testEquation() {
        doReturn(3.0).when(calculator).sqrt(eq(9.0));
        doReturn(2.0).when(calculator).sqrt(eq(4.0));

        double actualResult = calculator.sqrt(9) + calculator.sqrt(4);
        assertEquals(actualResult, 5.0);
    }
}
