package com.epam.forth.word;

import java.util.Deque;

public class Multiplication implements ForthWord {
    @Override
    public void accept(Deque<Integer> stack) {
        ForthWord.ensureSize(stack, 2, "Multiplication requires that the stack contain at least 2 values");
        stack.push(stack.pop() * stack.pop());
    }
}
