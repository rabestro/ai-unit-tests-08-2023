package leetcode.p191;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

// Test class: SolutionTest
@DisplayName("Solution BlackBoxC4Test")
class SolutionBlackBoxC4Test {

    // Our method for providing test cases
    private static Stream<Object[]> testProvider() {
        return Stream.of(
                new Object[]{"Test case with zero", 0, 0},
                new Object[]{"Test case with -1", -1, 32},
                new Object[]{"Test case with a positive number", 11, 3},
                new Object[]{"Test case with a number where only the MSB is set", 128, 1},
                new Object[]{"Test with the maximum  positive integer", Integer.MAX_VALUE, 31},
                new Object[]{"Test with the maximum negative integer", Integer.MIN_VALUE, 1}
        );
    }

    @DisplayName("Test hammingWeight method:")
    @ParameterizedTest(name = "[{index}] {0}: {1} -> {2}")
    @MethodSource("testProvider")
    void testHammingWeight(String description, int input, int expectedCount) {
        // Setup the class to test
        Solution solution = new Solution();

        // Do the test
        var result = solution.hammingWeight(input);

        // Assert the results
        assertThat(result)
                .as("In binary representation of '%d', the number of '1's should be '%d'", input, expectedCount)
                .isEqualTo(expectedCount);
    }
}
