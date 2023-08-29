package exercism.forth.word;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AdditionWhiteBoxC4Test {

    @DisplayName("Test Addition with different stack inputs")
    @ParameterizedTest(name = "Test case {0}: stack input={1}, expected stack output={2}")
    @CsvSource(delimiter = '|', textBlock = """
                1 | 5, 3       | 8
                2 | -5, -3     | -8
                3 | 5, -3      | 2
                4 | -5, 3      | -2
            """)
    void testAddition(int testCaseId, String stackInput, int expectedStackOutput) {
        var stack = createStackFromString(stackInput);
        var addition = new Addition();

        addition.accept(stack);

        assertThat(stack)
                .as("Test case %d: expected stack output is %d", testCaseId, expectedStackOutput)
                .containsExactly(expectedStackOutput);
    }

    @DisplayName("Test Addition with insufficient stack size")
    @ParameterizedTest(name = "Test case {0}: stack input={1}")
    @CsvSource(delimiter = '|', textBlock = """
                5 | 5
                6 |
            """)
    void testAdditionWithInsufficientStackSize(int testCaseId, String stackInput) {
        var stack = createStackFromString(stackInput);
        var addition = new Addition();

        assertThatThrownBy(() -> addition.accept(stack))
                .as("Test case %d: expected IllegalStateException", testCaseId)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Addition requires that the stack contain at least 2 values");
    }

    private Deque<Integer> createStackFromString(String stackInput) {
        var stack = new ArrayDeque<Integer>();
        if (stackInput != null && !stackInput.isEmpty()) {
            Arrays.stream(stackInput.split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .forEach(stack::push);
        }
        return stack;
    }
}
