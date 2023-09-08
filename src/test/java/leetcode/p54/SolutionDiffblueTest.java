package leetcode.p54;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import leetcode.p54.Solution;
import org.junit.jupiter.api.Test;

class SolutionDiffblueTest {
    /**
     * Method under test: {@link Solution#spiralOrder(int[][])}
     */
    @Test
    void testSpiralOrder() {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{new int[]{1, -1, 1, -1}};
        List<Integer> actualSpiralOrderResult = solution.spiralOrder(matrix);
        assertEquals(4, actualSpiralOrderResult.size());
        assertEquals(1, actualSpiralOrderResult.get(0));
        assertEquals(-1, actualSpiralOrderResult.get(1));
        assertEquals(1, actualSpiralOrderResult.get(2));
        assertEquals(-1, actualSpiralOrderResult.get(3));
    }

    /**
     * Method under test: {@link Solution#spiralOrder(int[][])}
     */
    @Test
    void testSpiralOrder2() {
        Solution solution = new Solution();
        int[][] matrix = new int[][]{};
        List<Integer> actualSpiralOrderResult = solution.spiralOrder(matrix);
        assertTrue(actualSpiralOrderResult.isEmpty());
    }
}
