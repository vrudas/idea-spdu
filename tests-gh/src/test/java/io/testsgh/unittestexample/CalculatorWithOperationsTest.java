package io.testsgh.unittestexample;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.testng.Assert.assertEquals;

public class CalculatorWithOperationsTest {

    private OperationWithOneArgument sqrtOperation = mock(OperationWithOneArgument.class);
    private OperationWithTwoArguments sumOperation = mock(OperationWithTwoArguments.class);

    private CalculatorWithOperations calculator;

    @BeforeMethod
    public void setUp() {
        calculator = new CalculatorWithOperations(sqrtOperation, sumOperation);
    }

    @DataProvider(name = "testAddParameters")
    public static Object[][] testAddParameters() {
        return new Object[][]{
            {1, 2, 3}
        };
    }

    @Test(dataProvider = "testAddParameters")
    public void testAdd(double x, double y, double expectedResult) {
        //arrange - test initialisation + stubs/mocks creation
        when(sumOperation.calculate(eq(1.0), eq(2.0))).thenReturn(3);

        //act - where the operation to be tested is performed
        double actualResult = calculator.add(x, y);

        //assert - received result assertion + mocks verification
        verifyZeroInteractions(sqrtOperation);
        assertEquals(actualResult, expectedResult);
    }

    @Test
    public void testSqrt() {
        when(sqrtOperation.calculate(eq(4.0))).thenReturn(2);

        double actualResult = calculator.sqrt(4);
        double expectedResult = 2;

        assertEquals(actualResult, expectedResult);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testSqrt_fail() {
        when(sqrtOperation.calculate(any())).thenThrow(IllegalArgumentException.class);

        calculator.sqrt(1);
    }
}