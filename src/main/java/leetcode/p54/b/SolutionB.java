package leetcode.p54.b;

import java.util.List;

import static java.util.Arrays.stream;

class SolutionB {
    public List<Integer> spiralOrder(int[][] matrix) {
        return new SpiralSupplier(matrix).get().boxed().toList();
    }
}

