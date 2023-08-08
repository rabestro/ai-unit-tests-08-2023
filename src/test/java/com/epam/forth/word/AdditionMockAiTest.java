package com.epam.forth.word;

import com.epam.forth.ForthStack;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@DisplayName("Addition Class Test")
class AdditionMockAiTest {
    private ForthStack stack;
    private Addition addition;

    @BeforeEach
    void setUp() {
        stack = Mockito.mock(ForthStack.class);
        addition = new Addition();
    }

    @Test
    @DisplayName("Addition of Two Positive Values Success Case")
    void testAdditionOfTwoPositiveValues() {
        when(stack.pop()).thenReturn(3, 2);
        addition.accept(stack);
        verify(stack, times(2)).pop();
        verify(stack).push(5);
    }

    @Test
    @DisplayName("Addition of Two Negative Values Success Case")
    void testAdditionOfTwoNegativeValues() {
        when(stack.pop()).thenReturn(-3, -2);
        addition.accept(stack);
        verify(stack, times(2)).pop();
        verify(stack).push(-5);
    }

    @Test
    @DisplayName("Addition of a Positive and a Negative Value Success Case")
    void testAdditionOfOnePositiveAndOneNegativeValue() {
        when(stack.pop()).thenReturn(2, -3);
        addition.accept(stack);
        verify(stack, times(2)).pop();
        verify(stack).push(-1);
    }

    @Test
    @DisplayName("Addition Stack Underflow Case (Not enough operands)")
    void testAdditionUnderflow() {
        when(stack.pop()).thenThrow(new IllegalStateException("Addition requires that the stack contain at least 2 values"));
        assertThrows(IllegalStateException.class, () -> addition.accept(stack));
        verify(stack).pop();
    }
}
