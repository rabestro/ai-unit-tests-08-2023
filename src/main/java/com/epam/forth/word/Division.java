package com.epam.forth.word;

import com.epam.forth.ForthStack;

public class Division implements ForthWord {
    @Override
    public void accept(ForthStack stack) {
        stack.ensureSize(2, "Division requires that the stack contain at least 2 values");
        int divisor = stack.pop();
        int dividend = stack.pop();
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by 0 is not allowed");
        }
        stack.push(dividend / divisor);
    }
}
