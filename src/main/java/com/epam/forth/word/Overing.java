package com.epam.forth.word;

import java.util.Deque;

import static java.util.Objects.requireNonNull;

public class Overing implements ForthWord {
    @Override
    public void accept(Deque<Integer> stack) {
        ForthWord.ensureSize(stack, 2, "Overing requires that the stack contain at least 2 values");
        int a = stack.pop();
        int b = requireNonNull(stack.peek());
        stack.push(a);
        stack.push(b);
    }
}
