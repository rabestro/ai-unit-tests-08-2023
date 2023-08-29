package exercism.forth.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SubtractionWhiteBoxAiTest {

    @Test
    @DisplayName("When the stack contains two values, it should subtract them")
    void subtractingTwoValues() {
        var subtraction = new Subtraction();
        var stack = new ArrayDeque<Integer>();
        stack.push(10);
        stack.push(2);

        subtraction.accept(stack);
        assertThat(stack)
                .as("After subtraction, the stack should contain the difference of the original values")
                .containsExactly(8);
    }

    @Test
    @DisplayName("When the stack contains multiple values, it should subtract the top two and leave the rest")
    void subtractingTopTwoValuesFromMultipleValues() {
        var subtraction = new Subtraction();
        var stack = new ArrayDeque<Integer>();
        stack.push(30);
        stack.push(20);
        stack.push(10);

        subtraction.accept(stack);
        assertThat(stack)
                .as("After subtraction, the stack should contain the remaining value and the difference of the top two original values")
                .containsExactly(10, 30);
    }

    @Test
    @DisplayName("An exception should be thrown when trying to subtract values from a stack with less than two values")
    void throwingExceptionWhenSubtractingFromLessThanTwoValues() {
        var subtraction = new Subtraction();
        var stack = new ArrayDeque<Integer>();
        stack.push(10);
        
        assertThatThrownBy(() -> subtraction.accept(stack))
                .as("An IllegalStateException was expected when subtracting less than two values")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Subtraction requires that the stack contain at least 2 values");
    }

    @Test
    @DisplayName("An exception should be thrown when trying to subtract values from an empty stack")
    void throwingExceptionWhenSubtractingFromEmpty() {
        var subtraction = new Subtraction();
        var stack = new ArrayDeque<Integer>();

        assertThatThrownBy(() -> subtraction.accept(stack))
                .as("An IllegalStateException was expected when subtracting on an empty stack")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Subtraction requires that the stack contain at least 2 values");
    }
}
