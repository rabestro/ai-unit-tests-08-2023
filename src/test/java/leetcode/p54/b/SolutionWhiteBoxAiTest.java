package leetcode.p54.b;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Testing Solution class with WhiteBox technique")
public class SolutionWhiteBoxAiTest {

    private static Stream<Object[]> testCases() {
        return Stream.of(new Object[][]{
                {"The matrix is a 2x2 square", new int[][]{{1, 2}, {4, 3}}, List.of(1, 2, 3, 4)},
                {"The matrix is a 3x3 square",
                        new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}},
                        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9)},
                {"The matrix is a 4x4 square",
                        new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}},
                        List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16)},
                {"The matrix is a 1x1 square", new int[][]{{1}}, List.of(1)},
                {"The matrix is a 3x1 rectangle", new int[][]{{1}, {2}, {3}}, List.of(1, 2, 3)},
                {"The matrix is a 1x3 rectangle", new int[][]{{1, 2, 3}}, List.of(1, 2, 3)},
                {"The matrix is an empty 1x1 square", new int[][]{{}}, List.of()},
                {"The matrix is an empty 2x0 rectangle", new int[][]{{}, {}}, List.of()}});
    }

    @DisplayName("SpiralOrder method should return the correct spiral order given a 2D array")
    @ParameterizedTest(name = "Test Case {index} => {0}")
    @MethodSource("testCases")
    void testSpiralOrder(String testCase, int[][] matrix, List<Integer> expected) {
        var solution = new Solution();
        assertThat(solution.spiralOrder(matrix))
                .as("Testing case: " + testCase)
                .isEqualTo(expected);
    }
}