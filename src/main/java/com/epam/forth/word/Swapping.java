package com.epam.forth.word;

import java.util.Deque;

public class Swapping implements ForthWord {
    @Override
    public void accept(Deque<Integer> stack) {
        ForthWord.ensureSize(stack, 2, "Swapping requires that the stack contain at least 2 values");
        int a = stack.pop();
        int b = stack.pop();
        stack.push(a);
        stack.push(b);
    }
}
