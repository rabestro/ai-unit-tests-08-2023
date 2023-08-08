package com.epam.forth;


import com.epam.forth.word.ForthWord;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import static com.epam.forth.word.ForthWord.isNumber;

public class ForthCore implements ForthEngine {
    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Map<String, Consumer<ForthStack>> words;

    public ForthCore() {
        words = new HashMap<>(ForthWord.builtInWords());
    }

    @Override
    public void push(int value) {
        stack.add(value);
    }

    @Override
    public int pop() {
        return stack.removeLast();
    }

    @Override
    public int peek() {
        return stack.getLast();
    }

    @Override
    public void ensureSize(int requiredSize, String errorMessage) {
        if (stack.size() < requiredSize) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    @Override
    public void accept(String token) {
        compileToken(token).accept(this);
    }

    @Override
    public List<Integer> asList() {
        return List.copyOf(stack);
    }

    @Override
    public void accept(String word, List<String> tokens) {
        validateWord(word);
        var compiledAction = tokens.stream()
                .map(this::compileToken)
                .reduce(Consumer::andThen)
                .orElse(ForthWord.undefinedWord(word));
        words.put(word, compiledAction);
    }

    private Consumer<ForthStack> compileToken(String token) {
        if (isNumber.test(token)) {
            return ForthWord.number(token);
        }
        return words.getOrDefault(token, ForthWord.undefinedWord(token));
    }

    private void validateWord(String word) {
        if (isNumber.test(word)) {
            throw new IllegalArgumentException("Cannot redefine numbers");
        }
    }
}
