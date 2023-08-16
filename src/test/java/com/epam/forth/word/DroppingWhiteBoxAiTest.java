package com.epam.forth.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class DroppingWhiteBoxAiTest {

    @Test
    @DisplayName("When stack contains one value, it should be dropped")
    void droppingOneValue() {
        var dropping = new Dropping();
        var stack = new ArrayDeque<Integer>();
        stack.push(10);

        dropping.accept(stack);
        assertThat(stack)
                .as("After dropping, the stack must be empty")
                .isEmpty();
    }

    @Test
    @DisplayName("When stack contains multiple values, the top one should be dropped")
    void droppingFromMultipleValues() {
        var dropping = new Dropping();
        var stack = new ArrayDeque<Integer>();
        stack.push(30);
        stack.push(20);
        stack.push(10);

        dropping.accept(stack);
        assertThat(stack)
                .as("After dropping, the stack must contain the original bottom and middle values")
                .containsExactly(20, 30);
    }

    @Test
    @DisplayName("An exception should be thrown when trying to drop from an empty stack")
    void throwingExceptionWhenDroppingFromEmpty() {
        var dropping = new Dropping();
        var stack = new ArrayDeque<Integer>();

        assertThatThrownBy(() -> dropping.accept(stack))
                .as("An IllegalStateException was expected when dropping on an empty stack")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Dropping requires that the stack contain at least 1 value");
    }
}
