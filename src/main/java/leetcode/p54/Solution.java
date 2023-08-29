package leetcode.p54;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;

class Solution {
    private int rows;
    private int cols;
    private int[][] matrix;

    public List<Integer> spiralOrder(int[][] matrix) {
        rows = matrix.length;
        if (rows == 0) {
            return List.of();
        }
        cols = matrix[0].length;
        if (cols == 0) {
            return List.of();
        }
        this.matrix = matrix;

        return spiralOrder(0);
    }

    List<Integer> spiralOrder(int level) {
        if (level > rows - 1 - level || level > cols - 1 - level) {
            return List.of();
        }
        if (level == rows - 1 - level) {
            return stream(matrix[level], level, cols - level).boxed().toList();
        }
        var result = new ArrayList<Integer>();
        IntStream.range(level, cols - level)
                .forEach(i -> result.add(matrix[level][i]));
        IntStream.range(level + 1, rows - level)
                .forEach(i -> result.add(matrix[i][cols - 1 - level]));
        IntStream.range(level + 1, cols - level)
                .map(i -> cols - 1 - i)
                .forEach(i -> result.add(matrix[rows - 1 - level][i]));

        IntStream.range(level + 1, rows - level - 1)
                .map(i -> rows - 1 - i)
                .forEach(i -> result.add(matrix[i][level]));
        result.addAll(spiralOrder(level + 1));
        return result;
    }
}
