package com.epam.forth.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class DuplicationWhiteBoxAiTest {

    @Test
    @DisplayName("When the stack contains one value, it should be duplicated")
    void duplicatingOneValue() {
        var duplication = new Duplication();
        var stack = new ArrayDeque<Integer>();
        stack.push(10);

        duplication.accept(stack);
        assertThat(stack)
                .as("After duplication, the stack should contain two identical values")
                .containsExactly(10, 10);
    }

    @Test
    @DisplayName("When the stack contains multiple values, the top one should be duplicated")
    void duplicatingTopValueFromMultipleValues() {
        var duplication = new Duplication();
        var stack = new ArrayDeque<Integer>();
        stack.push(30);
        stack.push(20);
        stack.push(10);

        duplication.accept(stack);
        assertThat(stack)
                .as("After duplication, the stack should contain the original values with an extra copy of the top value")
                .containsExactly(10, 10, 20, 30);
    }

    @Test
    @DisplayName("An exception should be thrown when trying to duplicate a value from an empty stack")
    void throwingExceptionWhenDuplicatingFromEmpty() {
        var duplication = new Duplication();
        var stack = new ArrayDeque<Integer>();

        assertThatThrownBy(() -> duplication.accept(stack))
                .as("An IllegalStateException was expected when duplicating an empty stack")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Duplicating requires that the stack contain at least 1 value");
    }
}
