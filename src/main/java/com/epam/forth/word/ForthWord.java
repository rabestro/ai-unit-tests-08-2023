package com.epam.forth.word;


import java.util.Deque;
import java.util.Map;
import java.util.function.Consumer;

@FunctionalInterface
public interface ForthWord extends Consumer<Deque<Integer>> {

    static Map<String, ForthWord> builtInWords() {
        return Map.of("+", new Addition(), "-", new Subtraction(), "*", new Multiplication(), "/", new Division(), "dup", new Duplication(), "drop", new Dropping(), "swap", new Swapping(), "over", new Overing());
    }

    static void ensureSize(Deque<Integer> stack, int requiredSize, String errorMessage) {
        if (stack.size() < requiredSize) {
            throw new IllegalStateException(errorMessage);
        }
    }

    static ForthWord number(String token) {
        return stack -> stack.push(Integer.parseInt(token));
    }
}
