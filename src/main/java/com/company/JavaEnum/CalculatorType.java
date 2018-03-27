package com.company.JavaEnum;

import java.util.function.Function;

public enum CalculatorType {
    CAL_A(value -> value),
    CAL_B(value -> value * 10),
    CAL_C(value -> value * 3),
    CAL_ETC(value -> 0L);

    private Function<Long, Long> expression;
    CalculatorType (Function<Long, Long> expression)  {
        this.expression = expression;
    }

    public long calculate(long value) {
        return expression.apply(value);
    }
}
