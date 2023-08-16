package com.epam.forth.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SwappingWhiteBoxAiTest {

    @Test
    @DisplayName("When the stack contains two values, it should swap them")
    void swappingTwoValues() {
        var swapping = new Swapping();
        var stack = new ArrayDeque<Integer>();
        stack.push(10);
        stack.push(2);

        swapping.accept(stack);
        assertThat(stack)
                .as("After swapping, the stack should contain the original values in reverse order")
                .containsExactly(10, 2);
    }

    @Test
    @DisplayName("When the stack contains multiple values, it should swap the top two and leave the rest")
    void swappingTopTwoValuesFromMultipleValues() {
        var swapping = new Swapping();
        var stack = new ArrayDeque<Integer>();
        stack.push(30);
        stack.push(20);
        stack.push(10);

        swapping.accept(stack);
        assertThat(stack)
                .as("After swapping, the stack should contain the original values with the top two swapped")
                .containsExactly(20, 10, 30);
    }

    @Test
    @DisplayName("An exception should be thrown when trying to swap values from a stack with less than two values")
    void throwingExceptionWhenSwappingLessThanTwoValues() {
        var swapping = new Swapping();
        var stack = new ArrayDeque<Integer>();
        stack.push(10);

        assertThatThrownBy(() -> swapping.accept(stack))
                .as("An IllegalStateException was expected when swapping less than two values")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Swapping requires that the stack contain at least 2 values");
    }

    @Test
    @DisplayName("An exception should be thrown when trying to swap values from an empty stack")
    void throwingExceptionWhenSwappingFromEmpty() {
        var swapping = new Swapping();
        var stack = new ArrayDeque<Integer>();

        assertThatThrownBy(() -> swapping.accept(stack))
                .as("An IllegalStateException was expected when swapping on an empty stack")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Swapping requires that the stack contain at least 2 values");
    }
}
