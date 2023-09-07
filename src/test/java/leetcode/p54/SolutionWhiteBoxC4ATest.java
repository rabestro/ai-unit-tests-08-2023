package leetcode.p54;

import leetcode.p54.b.SolutionB;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionWhiteBoxC4ATest {

    private final SolutionB solution = new SolutionB();

    @DisplayName("Spiral order of matrix")
    @ParameterizedTest(name = "{index}. {0}")
    @MethodSource("spiralOrderTestCases")
    void spiralOrder(String description, int[][] matrix, List<Integer> expectedResult) {
        var actualResult = solution.spiralOrder(matrix);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> spiralOrderTestCases() {
        return Stream.of(
                Arguments.of("Empty matrix", new int[][]{}, List.of()),
                Arguments.of("Matrix with only one row", new int[][]{{1, 2, 3}}, List.of(1, 2, 3)),
                Arguments.of("Matrix with only one column", new int[][]{{1}, {2}, {3}}, List.of(1, 2, 3)),
                Arguments.of("Square matrix with odd dimensions", new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)),
                Arguments.of("Square matrix with even dimensions", new int[][]{{1, 2}, {3, 4}}, List.of(1, 2, 4, 3)),
                Arguments.of("Rectangular matrix with more rows than columns", new int[][]{{1, 2}, {3, 4}, {5, 6}}, List.of(1, 2, 4, 6, 5, 3)),
                Arguments.of("Rectangular matrix with more columns than rows", new int[][]{{1, 2, 3}, {4, 5, 6}}, List.of(1, 2, 3, 6, 5, 4))
        );
    }
}
