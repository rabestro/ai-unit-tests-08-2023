package leetcode.p73;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionBlackBoxC4Test {

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of("Empty matrix",
                        new int[][]{},
                        new int[][]{}),
                Arguments.of("Single element matrix with non-zero value",
                        new int[][]{{1}},
                        new int[][]{{1}}),
                Arguments.of("Single element matrix with zero value",
                        new int[][]{{0}},
                        new int[][]{{0}}),
                Arguments.of("Matrix with no zeros",
                        new int[][]{{1, 2}, {3, 4}},
                        new int[][]{{1, 2}, {3, 4}}),
                Arguments.of("Matrix with a single zero",
                        new int[][]{{1, 2, 3}, {4, 0, 6}, {7, 8, 9}},
                        new int[][]{{1, 0, 3}, {0, 0, 0}, {7, 0, 9}}),
                Arguments.of("Matrix with multiple zeros",
                        new int[][]{{1, 2, 3}, {4, 0, 6}, {0, 8, 9}},
                        new int[][]{{0, 0, 3}, {0, 0, 0}, {0, 0, 0}}),
                Arguments.of("Matrix with all zeros",
                        new int[][]{{0, 0}, {0, 0}},
                        new int[][]{{0, 0}, {0, 0}}),
                Arguments.of("Non-square matrix with no zeros",
                        new int[][]{{1, 2, 3}, {4, 5, 6}},
                        new int[][]{{1, 2, 3}, {4, 5, 6}}),
                Arguments.of("Non-square matrix with a single zero",
                        new int[][]{{1, 2, 3, 4}, {5, 0, 7, 8}},
                        new int[][]{{1, 0, 3, 4}, {0, 0, 0, 0}}),
                Arguments.of("Non-square matrix with multiple zeros",
                        new int[][]{{1, 2, 3}, {4, 0, 6}, {7, 8, 9}, {0, 10, 11}},
                        new int[][]{{0, 0, 3}, {0, 0, 0}, {0, 0, 9}, {0, 0, 0}})
        );
    }

    @DisplayName("Set Zeroes")
    @ParameterizedTest(name = "Test case {index}: {0}")
    @MethodSource("testCases")
    void setZeroes(String description, int[][] input, int[][] expected) {
        var solution = new Solution();
        solution.setZeroes(input);
        assertThat(input)
                .as("Matrix after setting zeroes should match the expected matrix")
                .isEqualTo(expected);
    }
}
