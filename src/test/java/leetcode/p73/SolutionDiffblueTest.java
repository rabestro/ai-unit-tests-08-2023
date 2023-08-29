package leetcode.p73;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class SolutionDiffblueTest {
    /**
     * Method under test: {@link Solution#setZeroes(int[][])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSetZeroes() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 4
        //       at leetcode.p73.Solution.lambda$setZeroes$2(Solution.java:24)
        //       at java.base/java.util.stream.IntPipeline$10$1.accept(IntPipeline.java:392)
        //       at java.base/java.util.stream.Streams$RangeIntSpliterator.forEachRemaining(Streams.java:104)
        //       at java.base/java.util.Spliterator$OfInt.forEachRemaining(Spliterator.java:711)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        //       at java.base/java.util.stream.ForEachOps$ForEachOp$OfInt.evaluateSequential(ForEachOps.java:188)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.base/java.util.stream.IntPipeline.forEach(IntPipeline.java:463)
        //       at leetcode.p73.Solution.setZeroes(Solution.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Solution solution = new Solution();
        int[][] matrix = new int[][]{new int[]{2, 4, 2, 4, 2, 4, 2, 4}, new int[]{1, 4, 1, 4}};

        // Act
        solution.setZeroes(matrix);
    }

    /**
     * Method under test: {@link Solution#setZeroes(int[][])}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSetZeroes2() {
        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.ArrayIndexOutOfBoundsException: Index 0 out of bounds for length 0
        //       at leetcode.p73.Solution.lambda$setZeroes$2(Solution.java:24)
        //       at java.base/java.util.stream.IntPipeline$10$1.accept(IntPipeline.java:392)
        //       at java.base/java.util.stream.Streams$RangeIntSpliterator.forEachRemaining(Streams.java:104)
        //       at java.base/java.util.Spliterator$OfInt.forEachRemaining(Spliterator.java:711)
        //       at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:509)
        //       at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)
        //       at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
        //       at java.base/java.util.stream.ForEachOps$ForEachOp$OfInt.evaluateSequential(ForEachOps.java:188)
        //       at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
        //       at java.base/java.util.stream.IntPipeline.forEach(IntPipeline.java:463)
        //       at leetcode.p73.Solution.setZeroes(Solution.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        // Arrange
        Solution solution = new Solution();
        int[][] matrix = new int[][]{new int[]{1, 4, 1, 4}, new int[]{}};

        // Act
        solution.setZeroes(matrix);
    }
}
