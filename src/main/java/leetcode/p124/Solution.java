package leetcode.p124;

public class Solution {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        return Math.max(maxPathSumHelper(root), max);
    }

    private int maxPathSumHelper(TreeNode root) {
        if (root == null) return 0;
        int left = maxPathSumHelper(root.left);
        int right = maxPathSumHelper(root.right);
        int value = Math.max(root.val, root.val + Math.max(left, right));
        max = Math.max(max, Math.max(value, root.val + left + right));
        return value;
    }
}
