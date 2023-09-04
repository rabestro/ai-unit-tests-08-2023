package com.epam.flipflop;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("FlipFlopPredicate BlackBoxC4Test")
class FlipFlopPredicateBlackBoxC4Test {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Start and end conditions are never met",
                        (Predicate<Integer>) x -> x == 5,
                        (Predicate<Integer>) x -> x == 10,
                        List.of(1, 2, 3, 4),
                        List.of(false, false, false, false)),
                Arguments.of("Start condition is met, but the end condition is never met",
                        (Predicate<Integer>) x -> x == 2,
                        (Predicate<Integer>) x -> x == 10,
                        List.of(1, 2, 3, 4),
                        List.of(false, true, true, true)),
                Arguments.of("Start and end conditions are met in sequence",
                        (Predicate<Integer>) x -> x == 2,
                        (Predicate<Integer>) x -> x == 4,
                        List.of(1, 2, 3, 4, 5),
                        List.of(false, true, true, true, false)),
                Arguments.of("Start and end conditions are met simultaneously",
                        (Predicate<Integer>) x -> x % 2 == 0,
                        (Predicate<Integer>) x -> x % 2 == 0,
                        List.of(1, 2, 3, 4, 5),
                        List.of(false, true, false, true, false)),
                Arguments.of("Start and end conditions are never met with strings",
                        (Predicate<String>) s -> s.equals("start"),
                        (Predicate<String>) s -> s.equals("end"),
                        List.of("a", "b", "c", "d"),
                        List.of(false, false, false, false)),
                Arguments.of("Start condition is met, but the end condition is never met with strings",
                        (Predicate<String>) s -> s.equals("start"),
                        (Predicate<String>) s -> s.equals("end"),
                        List.of("a", "start", "c", "d"),
                        List.of(false, true, true, true)),
                Arguments.of("Start and end conditions are met in sequence with strings",
                        (Predicate<String>) s -> s.equals("start"),
                        (Predicate<String>) s -> s.equals("end"),
                        List.of("a", "start", "c", "end", "e"),
                        List.of(false, true, true, true, false)),
                Arguments.of("Start and end conditions are met simultaneously with strings",
                        (Predicate<String>) s -> s.startsWith("s"),
                        (Predicate<String>) s -> s.endsWith("t"),
                        List.of("a", "start", "c", "start", "e"),
                        List.of(false, true, false, true, false))
        );
    }

    @DisplayName("Test FlipFlopPredicate with various conditions and input types")
    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("testCases")
    <T> void testFlipFlopPredicate(String description, Predicate<T> startCondition, Predicate<T> endCondition, List<T> values, List<Boolean> expectedOutput) {
        var flipFlopPredicate = new FlipFlopPredicate<>(startCondition, endCondition);
        var actualOutput = values.stream().map(flipFlopPredicate::test).toList();

        assertThat(actualOutput)
                .withFailMessage("Expected output: %s, but was: %s", expectedOutput, actualOutput)
                .isEqualTo(expectedOutput);
    }
}
