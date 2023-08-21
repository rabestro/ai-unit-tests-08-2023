package leetcode.p100;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Solution class test suite")
class SolutionAiTest {
    private final Solution solution = new Solution();

    private static Stream<Arguments> provideTestParams() {
        return Stream.of(
                Arguments.of("Both trees are null", null, null, true),
                Arguments.of("First tree is null and the second one isn't",
                        null,
                        new TreeNode(1),
                        false),
                Arguments.of("Second tree is null and the first one isn't",
                        new TreeNode(1),
                        null,
                        false),
                Arguments.of("Both trees have one node, and their values are the same",
                        new TreeNode(1),
                        new TreeNode(1),
                        true),
                Arguments.of("Both trees have one node, and their values differ",
                        new TreeNode(1),
                        new TreeNode(2),
                        false),
                Arguments.of("Both trees have more than one node, with structures and node values that match",
                        tree1(),
                        tree1(),
                        true),
                Arguments.of("Both trees have the same structure, but at least one pair of corresponding nodes have different values",
                        tree1(),
                        tree2(),
                        false),
                Arguments.of("The trees have different structures",
                        tree1(),
                        new TreeNode(1),
                        false)
        );
    }

    private static TreeNode tree1() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        return tree;
    }

    private static TreeNode tree2() {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(4);
        tree.right = new TreeNode(3);
        return tree;
    }

    @DisplayName("Is same tree test")
    @ParameterizedTest(name = "[{index}] Scenario: {0}")
    @MethodSource("provideTestParams")
    void isSameTree_ShouldCheckIfTwoTreesAreTheSameOrNot(String scenario, TreeNode p, TreeNode q, boolean expectedResult) {
        var actual = solution.isSameTree(p, q);
        assertThat(actual)
                .as("%s. Expected output is %s", scenario, expectedResult)
                .isEqualTo(expectedResult);
    }
}
