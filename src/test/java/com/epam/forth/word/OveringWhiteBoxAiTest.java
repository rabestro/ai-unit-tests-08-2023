package com.epam.forth.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class OveringWhiteBoxAiTest {

    @Test
    @DisplayName("When the stack contains two values, it should perform an Over operation")
    void overingTwoValues() {
        var overing = new Overing();
        var stack = new ArrayDeque<Integer>();
        stack.push(10);
        stack.push(2);

        overing.accept(stack);
        assertThat(stack)
                .as("After overing, the stack should contain the original values in addition to the second-to-top value being copied to the top")
                .containsExactly(10, 2, 10);
    }

    @Test
    @DisplayName("When the stack contains multiple values, it should perform an Over operation on the top two and leaves the rest")
    void overingTopTwoValuesFromMultipleValues() {
        var overing = new Overing();
        var stack = new ArrayDeque<Integer>();
        stack.push(30);
        stack.push(20);
        stack.push(10);

        overing.accept(stack);
        assertThat(stack)
                .as("After overing, the stack should contain the original values with the second-to-top value copied to the top")
                .containsExactly(20, 10, 20, 30);
    }

    @Test
    @DisplayName("An exception should be thrown when trying to perform Over operation on a stack with less than two values")
    void throwingExceptionWhenOveringLessThanTwoValues() {
        var overing = new Overing();
        var stack = new ArrayDeque<Integer>();
        stack.push(10);

        assertThatThrownBy(() -> overing.accept(stack))
                .as("An IllegalStateException was expected when overing less than two values")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Overing requires that the stack contain at least 2 values");
    }

    @Test
    @DisplayName("An exception should be thrown when trying to perform Over operation on an empty stack")
    void throwingExceptionWhenOveringFromEmpty() {
        var overing = new Overing();
        var stack = new ArrayDeque<Integer>();

        assertThatThrownBy(() -> overing.accept(stack))
                .as("An IllegalStateException was expected when overing on an empty stack")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Overing requires that the stack contain at least 2 values");
    }
}
