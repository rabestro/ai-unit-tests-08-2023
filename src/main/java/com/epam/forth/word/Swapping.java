package com.epam.forth.word;

import com.epam.forth.ForthStack;

public class Swapping implements ForthWord {
    @Override
    public void accept(ForthStack stack) {
        stack.ensureSize(2, "Swapping requires that the stack contain at least 2 values");
        int a = stack.pop();
        int b = stack.pop();
        stack.push(a);
        stack.push(b);
    }
}
