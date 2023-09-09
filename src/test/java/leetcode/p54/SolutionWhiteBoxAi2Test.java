package leetcode.p54;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Solution: Spiral Order Test")
class SolutionWhiteBoxAi2Test {

    private final Solution underTest = new Solution();

    @SuppressWarnings("unused")
    @ParameterizedTest(name = "Test Case {index} => {0}")
    @MethodSource("spiralOrderDataProvider")
    void spiralOrderTest(String description, int[][] input, List<Integer> expected) {
        var actual = underTest.spiralOrder(input);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> spiralOrderDataProvider() {
        return Stream.of(
                /* Test Case 1 */
                Arguments.of(
                        "Edge case of empty matrix",
                        new int[][]{},
                        List.of()
                ),

                /* Test Case 2 */
                Arguments.of(
                        "Matrix with One Element",
                        new int[][]{{5}},
                        List.of(5)
                ),

                /* Test Case 3 */
                Arguments.of(
                        "Matrix of One Row",
                        new int[][]{{1, 2, 3, 4}},
                        List.of(1, 2, 3, 4)
                ),

                /* Test Case 4 */
                Arguments.of(
                        "Matrix of One Column",
                        new int[][]{{1}, {2}, {3}, {4}},
                        List.of(1, 2, 3, 4)
                ),

                /* Test Case 5 */
                Arguments.of(
                        "Standard 3x3 Matrix",
                        new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
                        List.of(1, 2, 3, 6, 9, 8, 7, 4, 5)
                ),

                /* Test Case 6 */
                Arguments.of(
                        "Asymmetric Matrix More Rows",
                        new int[][]{{1, 2}, {3, 4}, {5, 6}},
                        List.of(1, 2, 4, 6, 5, 3)
                ),

                /* Test Case 7 */
                Arguments.of(
                        "Asymmetric Matrix More Columns",
                        new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}},
                        List.of(1, 2, 3, 4, 8, 7, 6, 5)
                ),

                /* Test Case 8 */
                Arguments.of(
                        "Asymmetric Matrix with 10 Rows and 2 Columns",
                        new int[][]{
                                {1, 11}, {2, 12}, {3, 13}, {4, 14}, {5, 15},
                                {6, 16}, {7, 17}, {8, 18}, {9, 19}, {10, 20}
                        },
                        List.of(1, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 10, 9, 8, 7, 6, 5, 4, 3, 2)
                ),

                /* Test Case 9 */
                Arguments.of(
                        "5x5 Matrix",
                        new int[][]{
                                {1, 2, 3, 4, 5},
                                {6, 7, 8, 9, 10},
                                {11, 12, 13, 14, 15},
                                {16, 17, 18, 19, 20},
                                {21, 22, 23, 24, 25}
                        },
                        List.of(1, 2, 3, 4, 5, 10, 15, 20, 25, 24, 23, 22, 21, 16, 11, 6, 7, 8, 9, 14, 19, 18, 17, 12, 13)
                ),

                /* Test Case 10 */
                Arguments.of(
                        "Matrix with negative numbers",
                        new int[][]{
                                {-1, -2, -3},
                                {-4, -5, -6},
                                {-7, -8, -9}
                        },
                        List.of(-1, -2, -3, -6, -9, -8, -7, -4, -5)
                )
        );
    }
}