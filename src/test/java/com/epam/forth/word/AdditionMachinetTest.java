package com.epam.forth.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdditionMachinetTest {

    @Test
    @DisplayName("Should correctly add two numbers at the top of the stack")
    void acceptWhenStackHasTwoNumbers() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(5);
        stack.push(10);

        ForthWord addition = new Addition();
        addition.accept(stack);

        assertEquals(15, stack.pop());
    }

    @Test
    @DisplayName("Should throw an exception when the stack has less than two values")
    void acceptWhenStackHasLessThanTwoValuesThenThrowException() {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(5);

        ForthWord addition = new Addition();

        assertThrows(IllegalStateException.class, () -> addition.accept(stack));
    }

}
