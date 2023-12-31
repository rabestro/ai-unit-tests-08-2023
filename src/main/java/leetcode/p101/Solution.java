package leetcode.p101;

import leetcode.TreeNode;

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }

    boolean isSymmetric(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null) {
            return false;
        }
        return (
                leftNode.val == rightNode.val
                && isSymmetric(leftNode.left, rightNode.right)
                && isSymmetric(leftNode.right, rightNode.left)
        );
    }
}
