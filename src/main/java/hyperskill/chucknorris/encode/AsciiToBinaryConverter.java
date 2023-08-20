package hyperskill.chucknorris.encode;

import java.util.function.UnaryOperator;

import static java.util.stream.Collectors.joining;

public final class AsciiToBinaryConverter implements UnaryOperator<String> {
    private static final int HIGH_BIT = 0x80;
    private static final int ASCII_MASK = 0x7F;

    @Override
    public String apply(String text) {
        return text.chars()
                .mapToObj(this::charToBinary)
                .collect(joining());
    }

    private String charToBinary(int value) {
        return Integer.toBinaryString(value & ASCII_MASK | HIGH_BIT).substring(1);
    }
}
