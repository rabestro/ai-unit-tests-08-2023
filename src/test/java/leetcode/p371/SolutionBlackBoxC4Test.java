package leetcode.p371;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionBlackBoxC4Test {

    @DisplayName("getSum method black box testing:")
    @ParameterizedTest(name = "Test Case {index}: a = {0}, b = {1} -> Expected Output = {2}")
    @CsvSource(delimiter = '|', textBlock = """
                        1  |      2  |     3
                        2  |      3  |     5
                    -1000  |  -1000  | -2000
                     1000  |   1000  |  2000
                        0  |      0  |     0
                     -500  |    500  |     0
                        0  |      5  |     5
                        0  |     -5  |    -5
                        5  |      0  |     5
                       -5  |      0  |    -5
            """)
    void getSumBlackBoxTest(int a, int b, int expectedOutput) {
        // Arrange
        Solution solution = new Solution();

        // Act
        int result = solution.getSum(a, b);

        // Assert
        assertThat(result)
                .as("The sum of %d and %d should be %d", a, b, expectedOutput)
                .isEqualTo(expectedOutput);
    }
}
