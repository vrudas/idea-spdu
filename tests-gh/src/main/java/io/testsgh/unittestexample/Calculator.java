package io.testsgh.unittestexample;

import java.util.Objects;

class Calculator {

    int add(Integer x, Integer y) {
        Objects.requireNonNull(x);
        Objects.requireNonNull(y);

        return x + y;
    }

    double sqrt(double x) {
        Objects.requireNonNull(x);

        if (x < 0) {
            throw new IllegalArgumentException("x (" + x + ") should be > 0");
        }
        return Math.sqrt(x);
    }
}
