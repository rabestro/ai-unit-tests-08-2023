package com.epam.forth.word;

import java.util.Deque;

public final class Addition implements ForthWord {
    @Override
    public void accept(Deque<Integer> stack) {
        ForthWord.ensureSize(stack, 2, "Addition requires that the stack contain at least 2 values");
        stack.push(stack.pop() + stack.pop());
    }
}
