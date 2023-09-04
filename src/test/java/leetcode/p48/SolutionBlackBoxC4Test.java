package leetcode.p48;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionBlackBoxC4Test {

    private static Stream<Arguments> rotateMatrixTestCases() {
        return Stream.of(
                Arguments.of("Small matrix (2x2)", new int[][]{{1, 2}, {3, 4}}, new int[][]{{3, 1}, {4, 2}}),
                Arguments.of("Medium matrix (3x3)", new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}),
                Arguments.of("Large matrix (4x4)", new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, new int[][]{{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}}),
                Arguments.of("Single element (1x1)", new int[][]{{1}}, new int[][]{{1}}),
                Arguments.of("Empty matrix (0x0)", new int[][]{}, new int[][]{})
        );
    }

    @DisplayName("Rotate matrix")
    @ParameterizedTest(name = "Test case {index}: {0}")
    @MethodSource("rotateMatrixTestCases")
    void rotateMatrix(String description, int[][] input, int[][] expectedOutput) {
        var solution = new Solution();
        solution.rotate(input);
        assertThat(input)
                .as("The rotated matrix should match the expected output")
                .isEqualTo(expectedOutput);
    }
}
