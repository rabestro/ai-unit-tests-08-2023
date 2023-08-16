package com.epam.forth.word;

import java.util.Deque;

public class Division implements ForthWord {
    @Override
    public void accept(Deque<Integer> stack) {
        ForthWord.ensureSize(stack, 2, "Division requires that the stack contain at least 2 values");
        int divisor = stack.pop();
        int dividend = stack.pop();
        if (divisor == 0) {
            throw new IllegalArgumentException("Division by 0 is not allowed");
        }
        stack.push(dividend / divisor);
    }
}
