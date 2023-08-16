package com.epam.chucknorris;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public final class Application implements Runnable {
    private static final Predicate<String> ENCODED_STRING_PATTERN =
            Pattern.compile("00? 0+(?: 00? 0+)*").asMatchPredicate();
    private static final Pattern PATTERN = Pattern.compile("00? (0+) ?");

    private final Supplier<String> input;
    private final Consumer<? super String> output;
    private final Function<? super String, String> encoder;
    private final Function<? super String, String> decoder;

    public Application(
            Supplier<String> input, Consumer<? super String> output,
            Function<? super String, String> encoder, Function<? super String, String> decoder
    ) {
        this.input = input;
        this.output = output;
        this.encoder = encoder;
        this.decoder = decoder;
    }

    @Override
    public void run() {
        Stream.generate(this::requestOperation)
                .takeWhile(not("exit"::equals))
                .map(this::selectOperation)
                .forEach(Runnable::run);

        output.accept("Bye!");
    }

    private Runnable selectOperation(String userInput) {
        return switch (userInput) {
            case "encode" -> this::performEncoding;
            case "decode" -> this::performDecoding;
            default -> () -> output.accept("There is no '%s' operation".formatted(userInput));
        };
    }

    void performEncoding() {
        output.accept("Input string:");
        var result = encoder.apply(input.get());
        output.accept("Encoded string:");
        output.accept(result);
    }

    void performDecoding() {
        output.accept("Input encoded string:");
        var encodedString = input.get();
        if (isEncodedStringInvalid(encodedString)) {
            output.accept("Encoded string is not valid.");
            return;
        }
        var result = decoder.apply(encodedString);
        output.accept("Decoded string:");
        output.accept(result);
    }

    boolean isEncodedStringInvalid(String encodedString) {
        return !ENCODED_STRING_PATTERN.test(encodedString)
               || PATTERN.matcher(encodedString)
                          .replaceAll("$1")
                          .length() % 7 != 0;
    }

    private String requestOperation() {
        output.accept("Please input operation (encode/decode/exit):");
        return input.get();
    }
}
