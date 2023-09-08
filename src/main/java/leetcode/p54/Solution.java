package leetcode.p54;

import java.util.List;

import static java.util.Arrays.stream;

public final class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        return new SpiralSupplier(matrix).get().boxed().toList();
    }
}
