package leetcode.p54;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.range;

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

        return spiralOrder(0).boxed().toList();
    }

    IntStream spiralOrder(int level) {
        if (level > rows - 1 - level || level > cols - 1 - level) {
            return IntStream.empty();
        }
        if (level == rows - 1 - level) {
            return stream(matrix[level], level, cols - level);
        }
        var top = stream(matrix[level], level, cols - level);
        var right = range(level + 1, rows - level)
                .map(i -> matrix[i][cols - 1 - level]);
        var bottom = range(level + 1, cols - level)
                .map(i -> cols - 1 - i)
                .map(i -> matrix[rows - 1 - level][i]);
        var left = range(level + 1, rows - level - 1)
                .map(i -> rows - 1 - i)
                .map(i -> matrix[i][level]);

        return Stream.of(top, right, bottom, left, spiralOrder(level + 1))
                .flatMapToInt(i -> i);
    }
}
