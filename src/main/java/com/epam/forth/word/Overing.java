package com.epam.forth.word;

import com.epam.forth.ForthStack;

public final class Overing implements ForthWord {
    @Override
    public void accept(ForthStack stack) {
        stack.ensureSize(2, "Overing requires that the stack contain at least 2 values");
        int a = stack.pop();
        int b = stack.peek();
        stack.push(a);
        stack.push(b);
    }
}
