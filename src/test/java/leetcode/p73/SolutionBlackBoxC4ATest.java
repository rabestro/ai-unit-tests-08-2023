package leetcode.p73;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionBlackBoxC4ATest {

    @DisplayName("Set Zeroes")
    @ParameterizedTest(name = "Test Case {index}: {0}")
    @MethodSource("testCases")
    void setZeroes(String description, int[][] inputMatrix, int[][] expectedMatrix) {
        var solution = new Solution();
        solution.setZeroes(inputMatrix);
        assertThat(inputMatrix)
            .as(description)
            .isEqualTo(expectedMatrix);
    }

    private static Stream<Object[]> testCases() {
        return Stream.of(
            new Object[]{"Smallest possible matrix (1x1)", new int[][]{{0}}, new int[][]{{0}}},
            new Object[]{"Matrix with only one row", new int[][]{{1, 0, 3}}, new int[][]{{0, 0, 0}}},
            new Object[]{"Matrix with only one column", new int[][]{{1}, {0}, {3}}, new int[][]{{0}, {0}, {0}}},
            new Object[]{"Matrix with no zeros", new int[][]{{1, 2}, {3, 4}}, new int[][]{{1, 2}, {3, 4}}},
            new Object[]{"Matrix with at least one zero", new int[][]{{1, 2, 0}, {3, 4, 5}}, new int[][]{{0, 0, 0}, {3, 4, 0}}},
            new Object[]{"Matrix with zeros in all rows and columns", new int[][]{{0, 2, 0}, {3, 0, 5}, {0, 4, 0}}, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
            new Object[]{"Matrix with zeros only in the first row", new int[][]{{0, 0, 0}, {1, 2, 3}}, new int[][]{{0, 0, 0}, {0, 0, 0}}},
            new Object[]{"Matrix with zeros only in the last row", new int[][]{{1, 2, 3}, {0, 0, 0}}, new int[][]{{0, 0, 0}, {0, 0, 0}}},
            new Object[]{"Matrix with zeros only in the first column", new int[][]{{0, 1}, {0, 2}, {0, 3}}, new int[][]{{0, 0}, {0, 0}, {0, 0}}},
            new Object[]{"Matrix with zeros only in the last column", new int[][]{{1, 0}, {2, 0}, {3, 0}}, new int[][]{{0, 0}, {0, 0}, {0, 0}}},
            new Object[]{"Matrix with zeros in a diagonal pattern", new int[][]{{0, 1, 2}, {3, 0, 4}, {5, 6, 0}}, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}},
            new Object[]{"Matrix with zeros in a reverse diagonal pattern", new int[][]{{1, 2, 0}, {3, 0, 4}, {0, 5, 6}}, new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}}
        );
    }
}
