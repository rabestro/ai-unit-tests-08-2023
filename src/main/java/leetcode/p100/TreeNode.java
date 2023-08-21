package leetcode.p100;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node != null) {
                sb.append(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                sb.append("null");
            }

            if (!queue.isEmpty()) {
                sb.append(",");
            }
        }

        sb.append("]");
        return sb.toString();
    }
}
