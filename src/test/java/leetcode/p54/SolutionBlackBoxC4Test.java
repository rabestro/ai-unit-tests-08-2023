package leetcode.p54;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionBlackBoxC4Test {

    @DisplayName("Spiral Order Matrix")
    @ParameterizedTest(name = "Test Case {index}: Matrix {0} => Spiral Order {1}")
    @MethodSource("spiralOrderTestCases")
    void spiralOrderTest(int[][] matrix, List<Integer> expectedSpiralOrder) {
        var solution = new Solution();
        var actualSpiralOrder = solution.spiralOrder(matrix);
        assertThat(actualSpiralOrder)
                .as("The spiral order of the matrix should be %s", expectedSpiralOrder)
                .isEqualTo(expectedSpiralOrder);
    }

    private static Stream<Arguments> spiralOrderTestCases() {
        return Stream.of(
                Arguments.of(new int[][]{}, List.of()),
                Arguments.of(new int[][]{{1}}, List.of(1)),
                Arguments.of(new int[][]{{1, 2}, {4, 3}}, List.of(1, 2, 3, 4)),
                Arguments.of(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)),
                Arguments.of(new int[][]{{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}}, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12)),
                Arguments.of(new int[][]{{1, 2, 3}, {10, 11, 4}, {9, 12, 5}, {8, 7, 6}}, List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12))
        );
    }
}
