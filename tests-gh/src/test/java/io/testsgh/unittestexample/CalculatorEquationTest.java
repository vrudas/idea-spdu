package io.testsgh.unittestexample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class CalculatorEquationTest {

    private OperationWithOneArgument sqrtOperation = mock(OperationWithOneArgument.class);
    private OperationWithTwoArguments sumOperation = mock(OperationWithTwoArguments.class);

    private CalculatorWithOperations calculator;

    @BeforeMethod
    public void setUp() {
        calculator = spy(new CalculatorWithOperations(
            (x) -> 1,
            (x, y) -> x.doubleValue() + y.doubleValue()
        ));
    }

    @DataProvider(name = "testCalculationOfEquationParameters")
    public static Object[][] testCalculationOfEquationParameters() {
        return new Object[][]{
            {4.0, 4.0, 4.0}
        };
    }

    @Test(dataProvider = "testCalculationOfEquationParameters")
    public void testCalculationOfEquation(Double x, Double y, Double expectedSum) {
        doReturn(Math.sqrt(x)).when(calculator).sqrt(eq(x));
        doReturn(Math.sqrt(y)).when(calculator).sqrt(eq(y));

        double sqrtX = calculator.sqrt(x);
        double sqrtY = calculator.sqrt(y);
        double sumOfSqrts = calculator.add(sqrtX, sqrtY);

        assertEquals(sumOfSqrts, expectedSum);
    }
}
