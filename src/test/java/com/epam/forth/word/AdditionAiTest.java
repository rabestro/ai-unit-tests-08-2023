package com.epam.forth.word;

import com.epam.forth.ForthCore;
import com.epam.forth.ForthStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Addition Class Test")
class AdditionAiTest {

    private ForthStack stack;
    private Addition addition;

    @BeforeEach
    void setUp() {
        stack = new ForthCore();
        addition = new Addition();
    }

    @Test
    @DisplayName("Addition of Two Positive Values Success Case")
    void testAdditionOfTwoPositiveValues() {
        stack.push(2);
        stack.push(3);
        addition.accept(stack);
        var result = stack.pop();
        assertEquals(5, result, "The addition of 2 and 3 should equal 5");
    }

    @Test
    @DisplayName("Addition of Two Negative Values Success Case")
    void testAdditionOfTwoNegativeValues() {
        stack.push(-2);
        stack.push(-3);
        addition.accept(stack);
        var result = stack.pop();
        assertEquals(-5, result, "The addition of -2 and -3 should equal -5");
    }

    @Test
    @DisplayName("Addition of a Positive and a Negative Value Success Case")
    void testAdditionOfOnePositiveOneNegativeValues() {
        stack.push(-2);
        stack.push(5);
        addition.accept(stack);
        var result = stack.pop();
        assertEquals(3, result, "The addition of -2 and 5 should equal 3");
    }

    @Test
    @DisplayName("Addition Stack Underflow Case (Not enough operands)")
    void testAdditionUnderflow() {
        assertThrows(IllegalArgumentException.class, () -> {
            addition.accept(stack);
        }, "Addition requires that the stack contain at least 2 values");
    }
}
