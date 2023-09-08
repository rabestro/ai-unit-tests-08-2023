package leetcode.p94;

import leetcode.TreeNode;

import java.util.List;

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        var result = new java.util.ArrayList<Integer>();
        inorderTraversal(root, result);
        return result;
    }

    private void inorderTraversal(TreeNode root, List<? super Integer> result) {
        if (root == null) {
            return;
        }

        inorderTraversal(root.left, result);
        result.add(root.val);
        inorderTraversal(root.right, result);
    }
}
