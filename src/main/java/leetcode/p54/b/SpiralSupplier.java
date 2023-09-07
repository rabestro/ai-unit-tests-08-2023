package leetcode.p54.b;

import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.IntStream.concat;
import static java.util.stream.IntStream.range;

public final class SpiralSupplier implements Supplier<IntStream> {
    private final int rows;
    private final int cols;
    private final int[][] matrix;

    SpiralSupplier(int[][] matrix) {
        this.rows = matrix.length;
        this.cols = rows > 0 ? matrix[0].length : 0;
        this.matrix = matrix;
    }

    @Override
    public IntStream get() {
        return new InnerMatrix(0).get();
    }

    private final class InnerMatrix implements Supplier<IntStream> {
        private final int level;

        private InnerMatrix(int level) {
            this.level = level;
        }

        private int innerRows() {
            return rows - 2 * level;
        }

        private int innerCols() {
            return cols - 2 * level;
        }

        private boolean isEmpty() {
            return innerRows() < 1 || innerCols() < 1;
        }

        private IntStream top() {
            return stream(matrix[level], level, cols - level);
        }

        private IntStream right() {
            return range(level + 1, rows - level).map(i -> matrix[i][cols - 1 - level]);
        }

        private IntStream bottom() {
            return range(level + 1, cols - level).map(i -> cols - 1 - i).map(i -> matrix[rows - 1 - level][i]);
        }

        private IntStream left() {
            return range(level + 1, rows - level - 1).map(i -> rows - 1 - i).map(i -> matrix[i][level]);
        }

        private IntStream boundaries() {
            return Stream.of(top(), right(), bottom(), left())
                    .reduce(IntStream.empty(), IntStream::concat);
        }

        private boolean isBaseCase() {
            return isEmpty() || innerRows() == 1 || innerCols() == 1;
        }

        private IntStream oneRow() {
            return stream(matrix[level], level, cols - level);
        }

        private IntStream oneColumn() {
            return range(level, rows - level).map(i -> matrix[i][level]);
        }

        private IntStream baseCase() {
            if (isEmpty()) {
                return IntStream.empty();
            }
            return innerRows() == 1 ? oneRow() : oneColumn();
        }

        private IntStream innerMatrix() {
            return new InnerMatrix(level + 1).get();
        }

        @Override
        public IntStream get() {
            if (isBaseCase()) {
                return baseCase();
            }
            return concat(boundaries(), innerMatrix());
        }
    }
}
