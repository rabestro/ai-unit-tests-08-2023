package leetcode.p48;

public class Solution {
    public void rotate(int[][] matrix) {
        for (int a = matrix.length / 2 - 1; a >= 0; a--) {
            int b = matrix.length - 1 - a;
            for (int i = matrix.length - a * 2 - 2; i >= 0; i--) {
                int tmp = matrix[a][a + i];
                matrix[a][a + i] = matrix[b - i][a];
                matrix[b - i][a] = matrix[b][b - i];
                matrix[b][b - i] = matrix[a + i][b];
                matrix[a + i][b] = tmp;
            }
        }
    }
}
