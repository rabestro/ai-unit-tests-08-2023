package exercism.forth.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.*;

class DivisionC4Test {

    @DisplayName("Stack has exactly 2 elements, divisor not 0")
    @ParameterizedTest(name = "[{index}] Dividend: {0}, Divisor: {1}, Expected Result: {2}")
    @CsvSource(delimiter = '|', textBlock = """
                    10    |  2    |  5
                    -10   | -2    |  5
                    10    | -2    | -5
                    -10   |  2    | -5
                    1000  | 200   |  5
                    -1000 | -200  |  5
                    0     |  2    |  0
                    5     |  5    |  1
            """)
    void stackHasTwoElements(int dividend, int divisor, int expectedResult) {
        var stack = new ArrayDeque<Integer>();
        stack.push(dividend);
        stack.push(divisor);

        var division = new Division();
        division.accept(stack);

        assertThat(stack.pop())
                .as("The division result of %d and %d should be %d", dividend, divisor, expectedResult)
                .isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Stack has more than 2 elements, divisor not 0")
    void stackHasMoreThanTwoElements() {
        var stack = new ArrayDeque<Integer>();
        stack.push(10);
        stack.push(5);
        stack.push(2);

        var division = new Division();
        division.accept(stack);

        assertThat(stack.pop())
                .as("The division result of 5 and 2 should be 2")
                .isEqualTo(2);
    }

    @Test
    @DisplayName("Stack has enough elements, divisor is 0")
    void stackHasEnoughElementsDivisorIsZero() {
        var stack = new ArrayDeque<Integer>();
        stack.push(10);
        stack.push(0);

        var division = new Division();

        assertThatIllegalArgumentException()
                .as("Division by 0 should throw IllegalArgumentException")
                .isThrownBy(() -> division.accept(stack))
                .withMessage("Division by 0 is not allowed");
    }

    @Test
    @DisplayName("Stack has only 1 element")
    void stackHasOnlyOneElement() {
        var stack = new ArrayDeque<Integer>();
        stack.push(10);

        var division = new Division();

        assertThatIllegalStateException()
                .as("Stack with only 1 element should throw IllegalStateException")
                .isThrownBy(() -> division.accept(stack));
    }

    @Test
    @DisplayName("Stack is empty")
    void stackIsEmpty() {
        var stack = new ArrayDeque<Integer>();

        var division = new Division();

        assertThatIllegalStateException()
                .as("Empty stack should throw IllegalStateException")
                .isThrownBy(() -> division.accept(stack));
    }
}
