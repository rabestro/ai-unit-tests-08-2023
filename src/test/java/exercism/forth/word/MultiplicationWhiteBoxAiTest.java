package exercism.forth.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MultiplicationWhiteBoxAiTest {

    @Test
    @DisplayName("When the stack contains two values, it should multiply them")
    void multiplyingTwoValues() {
        var multiplication = new Multiplication();
        var stack = new ArrayDeque<Integer>();
        stack.push(10);
        stack.push(2);

        multiplication.accept(stack);
        assertThat(stack)
                .as("After multiplication, the stack should contain the product of the original values")
                .containsExactly(20);
    }

    @Test
    @DisplayName("When the stack contains multiple values, it should multiply the top two and leave the rest")
    void multiplyingTopTwoValuesFromMultipleValues() {
        var multiplication = new Multiplication();
        var stack = new ArrayDeque<Integer>();
        stack.push(30);
        stack.push(20);
        stack.push(10);

        multiplication.accept(stack);
        assertThat(stack)
                .as("After multiplication, the stack should contain the remaining value and the product of the top two original values")
                .containsExactly(200, 30);
    }

    @Test
    @DisplayName("An exception should be thrown when trying to multiply values from a stack with less than two values")
    void throwingExceptionWhenMultiplyingFromLessThanTwoValues() {
        var multiplication = new Multiplication();
        var stack = new ArrayDeque<Integer>();
        stack.push(10);
        
        assertThatThrownBy(() -> multiplication.accept(stack))
                .as("An IllegalStateException was expected when multiplying less than two values")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Multiplication requires that the stack contain at least 2 values");
    }

    @Test
    @DisplayName("An exception should be thrown when trying to multiply values from an empty stack")
    void throwingExceptionWhenMultiplyingFromEmpty() {
        var multiplication = new Multiplication();
        var stack = new ArrayDeque<Integer>();

        assertThatThrownBy(() -> multiplication.accept(stack))
                .as("An IllegalStateException was expected when multiplying on an empty stack")
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Multiplication requires that the stack contain at least 2 values");
    }
}
