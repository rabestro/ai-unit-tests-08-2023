package com.epam.forth;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import com.epam.forth.word.ForthWord;

public final class ForthEngine implements Consumer<String>, Supplier<List<Integer>> {
    private static final Predicate<String> IS_NUMBER = Pattern.compile("\\d+").asMatchPredicate();
    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Map<String, Consumer<Deque<Integer>>> words;

    public ForthEngine() {
        words = new HashMap<>(ForthWord.builtInWords());
    }

    @Override
    public void accept(String command) {
        var tokens = tokenize(command);
        if (isWordDefinition(tokens)) {
            defineWord(tokens);
        } else {
            compile(tokens).accept(stack);
        }
    }

    @Override
    public List<Integer> get() {
        var list = new ArrayList<Integer>();
        stack.descendingIterator().forEachRemaining(list::add);
        return list;
    }

    private List<String> tokenize(String command) {
        return Arrays.asList(command.toLowerCase().split(" "));
    }

    private boolean isWordDefinition(List<String> tokens) {
        return ":".equals(tokens.get(0));
    }

    private void defineWord(List<String> tokens) {
        var word = validatedWord(tokens.get(1));
        var definition = tokens.subList(2, tokens.size() - 1);
        words.put(word, compile(definition));
    }

    private Consumer<Deque<Integer>> compile(List<String> tokens) {
        return tokens.stream().map(this::parseToken).reduce(Consumer::andThen).orElseThrow();
    }

    private Consumer<Deque<Integer>> parseToken(String token) {
        return evaluateToken(token)
                .orElseThrow(() -> new IllegalArgumentException("No definition available for operator \"" + token + "\""));
    }


    private Optional<Consumer<Deque<Integer>>> evaluateToken(String token) {
        return IS_NUMBER.test(token)
                ? Optional.of(stack -> stack.push(Integer.parseInt(token)))
                : Optional.ofNullable(words.get(token));
    }

    private String validatedWord(String word) {
        if (IS_NUMBER.test(word)) {
            throw new IllegalArgumentException("Cannot redefine numbers");
        }
        return word;
    }
}
