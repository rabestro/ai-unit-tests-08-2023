package com.epam.forth.word;

import java.util.Deque;

public class Dropping implements ForthWord {
    @Override
    public void accept(Deque<Integer> stack) {
        ForthWord.ensureSize(stack, 1, "Dropping requires that the stack contain at least 1 value");
        stack.pop();
    }
}
