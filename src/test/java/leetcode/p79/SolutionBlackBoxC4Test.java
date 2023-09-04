package leetcode.p79;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionBlackBoxC4Test {

    private final Solution solution = new Solution();

    @DisplayName("Word exists in the grid:")
    @ParameterizedTest(name = "[{index}] board: {0}, word: {1}, expected: {2}")
    @MethodSource("wordExistsInGridTestCases")
    void wordExistsInGrid(char[][] board, String word, boolean expected) {
        var actual = solution.exist(board, word);
        assertThat(actual)
                .as("The word '%s' should %s in the grid", word, expected ? "exist" : "not exist")
                .isEqualTo(expected);
    }

    private static Stream<Arguments> wordExistsInGridTestCases() {
        return Stream.of(
                Arguments.of(new char[][]{}, "hello", false),
                Arguments.of(new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}}, "", true),
                Arguments.of(new char[][]{{'a'}}, "a", true),
                Arguments.of(new char[][]{{'a'}}, "b", false),
                Arguments.of(new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}}, "abc", true),
                Arguments.of(new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}}, "adg", true),
                Arguments.of(new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}}, "aei", false),
                Arguments.of(new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}}, "xyz", false),
                Arguments.of(new char[][]{{'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}}, "deh", true),
                Arguments.of(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCCED", true),
                Arguments.of(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEE", true),
                Arguments.of(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB", false)
        );
    }
}
