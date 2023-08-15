package com.epam.chucknorris.encode;

import java.util.function.UnaryOperator;

import static java.util.stream.Collectors.joining;

/**
 * A utility class that converts a string to binary representation using ASCII encoding.
 * This class implements the UnaryOperator interface, allowing it to be used as a function
 * to convert a string using the apply method.
 */
public final class BinaryConverter implements UnaryOperator<String> {
    private static final int HIGH_BIT = 0x80;
    private static final int ASCII_MASK = 0x7F;

    @Override
    public String apply(String text) {
        return text.chars()
                .mapToObj(this::charToBinary)
                .collect(joining());
    }

    String charToBinary(int value) {
        return Integer.toBinaryString(value & ASCII_MASK | HIGH_BIT).substring(1);
    }
}
