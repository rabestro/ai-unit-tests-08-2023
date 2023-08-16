package com.epam.forth.word;

import java.util.Deque;

public class Subtraction implements ForthWord {
    @Override
    public void accept(Deque<Integer> stack) {
        ForthWord.ensureSize(stack, 2, "Subtraction requires that the stack contain at least 2 values");
        stack.push(-stack.pop() + stack.pop());
    }
}
