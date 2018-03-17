package io.testsgh.unittestexample;

import java.util.Objects;

class CalculatorWithOperations {

    private final OperationWithOneArgument sqrtOperation;
    private final OperationWithTwoArguments sumOperation;

    CalculatorWithOperations(
        OperationWithOneArgument sqrtOperation,
        OperationWithTwoArguments sumOperation
    ) {
        this.sqrtOperation = sqrtOperation;
        this.sumOperation = sumOperation;
    }

    double add(Double x, Double y) {
        Objects.requireNonNull(x);
        Objects.requireNonNull(y);

        return sumOperation.calculate(x, y).doubleValue();
    }

    double sqrt(double x) {
        Objects.requireNonNull(x);

        return sqrtOperation.calculate(x).doubleValue();
    }
}
