package leetcode.p94;

import leetcode.TreeNode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionC4Test {

    private Solution solution;

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    @DisplayName("Inorder traversal of a binary tree with one node")
    void testSingleNode() {
        var root = new TreeNode(1);

        var result = solution.inorderTraversal(root);

        assertThat(result)
                .as("Inorder traversal of a single-node tree should return the node's value")
                .containsExactly(1);
    }

    @Test
    @DisplayName("Inorder traversal of a binary tree with left child")
    void testLeftChild() {
        var root = new TreeNode(1);
        root.left = new TreeNode(2);

        var result = solution.inorderTraversal(root);

        assertThat(result)
                .as("Inorder traversal of a tree with left child should return the correct order")
                .containsExactly(2, 1);
    }

    @Test
    @DisplayName("Inorder traversal of a binary tree with right child")
    void testRightChild() {
        var root = new TreeNode(1);
        root.right = new TreeNode(2);

        var result = solution.inorderTraversal(root);

        assertThat(result)
                .as("Inorder traversal of a tree with right child should return the correct order")
                .containsExactly(1, 2);
    }

    @Test
    @DisplayName("Inorder traversal of a complete binary tree")
    void testCompleteBinaryTree() {
        var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        var result = solution.inorderTraversal(root);

        assertThat(result)
                .as("Inorder traversal of a complete binary tree should return the correct order")
                .containsExactly(2, 1, 3);
    }

    @Test
    @DisplayName("Inorder traversal of a binary tree with multiple nodes")
    void testMultipleNodes() {
        var root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        var result = solution.inorderTraversal(root);

        assertThat(result)
                .as("Inorder traversal of a binary tree with multiple nodes should return the correct order")
                .containsExactly(4, 2, 5, 1, 6, 3, 7);
    }
}
