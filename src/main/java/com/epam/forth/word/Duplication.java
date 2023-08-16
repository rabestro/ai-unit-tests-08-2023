package com.epam.forth.word;

import java.util.Deque;

public class Duplication implements ForthWord {
    @Override
    public void accept(Deque<Integer> stack) {
        ForthWord.ensureSize(stack, 1, "Duplicating requires that the stack contain at least 1 value");
        stack.push(stack.peek());
    }
}
