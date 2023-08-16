package com.epam.forth.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DivisionWhiteBoxAiTest {

    private static Stream<Arguments> provideTestCasesForDivision() {
        return Stream.of(
                Arguments.of(new ArrayDeque<>(List.of(2, 8)), new ArrayDeque<>(List.of(4))),
                Arguments.of(new ArrayDeque<>(List.of(3, -3)), new ArrayDeque<>(List.of(-1))),
                Arguments.of(new ArrayDeque<>(List.of(5, 0)), new ArrayDeque<>(List.of(0))),
                Arguments.of(new ArrayDeque<>(List.of(-2, -5)), new ArrayDeque<>(List.of(2)))
        );
    }

    @DisplayName("Test division operation:")
    @ParameterizedTest(name = "{index} - validates division operation with stack {0} and expected stack {1}")
    @MethodSource("provideTestCasesForDivision")
    void divisionOperationTest(Deque<Integer> stack, Deque<Integer> expectedStack) {
        new Division().accept(stack);
        assertThat(stack)
                .as("After division operation, the stack should match the expected stack")
                .usingRecursiveComparison()
                .isEqualTo(expectedStack);
    }

    @Test
    @DisplayName("Test division operation throws IllegalStateException with insufficient stack size")
    void divisionOperationExceptionIllegalState() {
        Deque<Integer> stack = new ArrayDeque<>(List.of(1));
        assertThatThrownBy(() -> new Division().accept(stack))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Division requires that the stack contain at least 2 values");
    }

    @Test
    @DisplayName("Test division operation throws IllegalArgumentException with division by zero")
    void divisionOperationExceptionIllegalArgument() {
        Deque<Integer> stack = new ArrayDeque<>(List.of(0, 5));
        assertThatThrownBy(() -> new Division().accept(stack))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Division by 0 is not allowed");
    }
}
