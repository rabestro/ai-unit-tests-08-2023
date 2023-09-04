package leetcode.p48;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionWhiteBoxC4Test {

    static Stream<Arguments> matrixRotationTestCases() {
        return Stream.of(
                Arguments.of("Empty matrix", new int[][]{}, new int[][]{}),
                Arguments.of("1x1 matrix", new int[][]{{1}}, new int[][]{{1}}),
                Arguments.of("2x2 matrix", new int[][]{{1, 2}, {3, 4}}, new int[][]{{3, 1}, {4, 2}}),
                Arguments.of("3x3 matrix", new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}),
                Arguments.of("4x4 matrix", new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}, new int[][]{{13, 9, 5, 1}, {14, 10, 6, 2}, {15, 11, 7, 3}, {16, 12, 8, 4}}),
                Arguments.of("5x5 matrix", new int[][]{{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}, {21, 22, 23, 24, 25}}, new int[][]{{21, 16, 11, 6, 1}, {22, 17, 12, 7, 2}, {23, 18, 13, 8, 3}, {24, 19, 14, 9, 4}, {25, 20, 15, 10, 5}})
        );
    }

    @DisplayName("Matrix rotation")
    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("matrixRotationTestCases")
    void testRotate(String description, int[][] inputMatrix, int[][] expectedMatrix) {
        var solution = new Solution();
        solution.rotate(inputMatrix);
        assertThat(inputMatrix)
                .as("The rotated matrix should match the expected matrix")
                .isEqualTo(expectedMatrix);
    }
}
