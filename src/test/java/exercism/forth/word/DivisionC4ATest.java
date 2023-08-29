package exercism.forth.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayDeque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

@DisplayName("Division Test")
class DivisionC4ATest {

    private final Division division = new Division();

    @DisplayName("Divides numbers:")
    @ParameterizedTest(name = "[{index}] {arguments}")
    @CsvSource(useHeadersInDisplayName = true, delimiter = '|', textBlock = """
            scenario              | dividend | divisor | result
            positive numbers      |       10 |       2 |      5
            positive and negative |      -15 |       3 |     -5
            negative and positive |       20 |      -4 |     -5
            negative numbers      |      -30 |      -6 |      5
        """)
    void dividesNumbers(String scenario, int dividend, int divisor, int expectedResult) {
        var stack = new ArrayDeque<Integer>();
        stack.push(dividend);
        stack.push(divisor);

        division.accept(stack);

        assertThat(stack)
                .as("The result of dividing %d by %d should be %d", dividend, divisor, expectedResult)
                .containsExactly(expectedResult);
    }

    @Test
    @DisplayName("Throws IllegalArgumentException when dividing by zero")
    void throwsIllegalArgumentExceptionWhenDividingByZero() {
        var stack = new ArrayDeque<Integer>();
        stack.push(10);
        stack.push(0);

        assertThatIllegalArgumentException()
                .as("Division by 0 is not allowed")
                .isThrownBy(() -> division.accept(stack));
    }

    @Test
    @DisplayName("Throws IllegalStateException when the stack is empty")
    void throwsIllegalStateExceptionWhenStackIsEmpty() {
        var stack = new ArrayDeque<Integer>();

        assertThatIllegalStateException()
                .as("Division requires that the stack contain at least 2 values")
                .isThrownBy(() -> division.accept(stack));
    }

    @Test
    @DisplayName("Throws IllegalStateException when the stack contains only one element")
    void throwsIllegalStateExceptionWhenStackContainsOnlyOneElement() {
        var stack = new ArrayDeque<Integer>();
        stack.push(10);

        assertThatIllegalStateException()
                .as("Division requires that the stack contain at least 2 values")
                .isThrownBy(() -> division.accept(stack));
    }
}
