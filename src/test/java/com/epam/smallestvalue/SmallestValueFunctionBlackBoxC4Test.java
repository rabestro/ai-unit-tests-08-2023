package com.epam.smallestvalue;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.function.LongUnaryOperator;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("SmallestValueFunction BlackBoxC4Test")
class SmallestValueFunctionBlackBoxC4Test {

    private final LongUnaryOperator smallestValueFunction = new SmallestValueFunction();

    @DisplayName("Test SmallestValueFunction:")
    @ParameterizedTest(name = "[{index}] {0}: {1} -> {2}")
    @MethodSource("testCases")
    void test(String description, long input, int expectedOutput) {
        var actualResult = smallestValueFunction.applyAsLong(input);
        assertThat(actualResult)
                .as("Checking SmallestValueFunction with input '%s'", input)
                .isEqualTo(expectedOutput);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
            Arguments.of("Largest negative value test", Long.MIN_VALUE, 0),
            Arguments.of("Negative value test", -100L, 0),
            Arguments.of("Zero value test", 0L, 0),
            Arguments.of("Smallest factorial larger than one", 1L, 2),
            Arguments.of("Small number test", 2L, 3),
            Arguments.of("Small number test", 3L, 3),
            Arguments.of("Small number test", 4L, 3),
            Arguments.of("Larger number test", 119L, 5),
            Arguments.of("Largest positive value test", Long.MAX_VALUE, 21)
       );
    }
}