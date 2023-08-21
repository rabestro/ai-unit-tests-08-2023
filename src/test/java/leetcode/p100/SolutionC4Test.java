package leetcode.p100;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionC4Test {

    private final Solution solution = new Solution();

    @Test
    @DisplayName("Both trees are null")
    void bothTreesAreNull() {
        var p = (TreeNode) null;
        var q = (TreeNode) null;

        assertThat(solution.isSameTree(p, q)).isTrue();
    }

    @Test
    @DisplayName("First tree is null, second tree is not")
    void firstTreeIsNull() {
        var p = (TreeNode) null;
        var q = new TreeNode(1);

        assertThat(solution.isSameTree(p, q)).isFalse();
    }

    @Test
    @DisplayName("Second tree is null, first tree is not")
    void secondTreeIsNull() {
        var p = new TreeNode(1);
        var q = (TreeNode) null;

        assertThat(solution.isSameTree(p, q)).isFalse();
    }

    @Test
    @DisplayName("Both trees have the same structure and the same node values")
    void sameStructureAndValues() {
        var p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        var q = new TreeNode(1, new TreeNode(2), new TreeNode(3));

        assertThat(solution.isSameTree(p, q)).isTrue();
    }

    @Test
    @DisplayName("Both trees have the same structure but different node values")
    void sameStructureDifferentValues() {
        var p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        var q = new TreeNode(1, new TreeNode(4), new TreeNode(3));

        assertThat(solution.isSameTree(p, q)).isFalse();
    }

    @Test
    @DisplayName("Both trees have different structures but the same node values")
    void differentStructureSameValues() {
        var p = new TreeNode(1, new TreeNode(2), null);
        var q = new TreeNode(1, null, new TreeNode(2));

        assertThat(solution.isSameTree(p, q)).isFalse();
    }

    @Test
    @DisplayName("Both trees have different structures and different node values")
    void differentStructureAndValues() {
        var p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        var q = new TreeNode(1, new TreeNode(2), new TreeNode(4));

        assertThat(solution.isSameTree(p, q)).isFalse();
    }
}
