package leetcode.p73;

import java.util.Arrays;
import java.util.BitSet;
import java.util.stream.IntStream;

class Solution {
    private int[][] matrix;

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        this.matrix = matrix;
        var rows = new BitSet(matrix.length);
        var cols = new BitSet(matrix[0].length);

        IntStream.range(0, matrix.length)
                .filter(r -> IntStream.of(matrix[r]).anyMatch(x -> x == 0))
                .forEach(rows::set);

        IntStream.range(0, matrix[0].length).filter(i -> {
            for (int[] ints : matrix) {
                if (ints[i] == 0) {
                    return true;
                }
            }
            return false;
        }).forEach(cols::set);

        IntStream.range(0, matrix.length).filter(rows::get).forEach(this::setRowToZero);
        IntStream.range(0, matrix[0].length).filter(cols::get).forEach(this::setColToZero);
    }

    private void setColToZero(int i) {
        for (int[] ints : matrix) {
            ints[i] = 0;
        }
    }

    private void setRowToZero(int row) {
        Arrays.fill(matrix[row], 0);
    }

}
