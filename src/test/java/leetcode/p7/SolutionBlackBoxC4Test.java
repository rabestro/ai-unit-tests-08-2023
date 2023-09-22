package leetcode.p7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionBlackBoxC4Test {

    private final Solution solution = new Solution();

    @DisplayName("Reverse Integer Test:")
    @ParameterizedTest(name = "[{index}] {0}")
    @CsvSource(delimiter = '|', textBlock = """
            Test Case 1: Positive number within the 32-bit integer range | 123          | 321
            Test Case 2: Negative number within the 32-bit integer range | -123         | -321
            Test Case 3: Positive number with trailing zeros             | 120          | 21
            Test Case 4: Negative number with trailing zeros             | -120         | -21
            Test Case 5: Maximum 32-bit integer                          | 2147483647   | 0
            Test Case 6: Minimum 32-bit integer                          | -2147483648  | 0
            Test Case 7: Zero                                            | 0            | 0
            Test Case 8: Maximum positive number that can be reversed    | 2147447412   | 2147447412
            Test Case 9: Maximum negative number that can be reversed    | -2147447412  | -2147447412
            """)
    void reverseIntegerTest(String description, int input, int expectedOutput) {
        var result = solution.reverse(input);
        assertThat(result)
                .withFailMessage("Expected reverse of %d to be %d, but got %d", input, expectedOutput, result)
                .isEqualTo(expectedOutput);
    }
}
