package leetcode.p54;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class FizzBuzzTest {
    private final int[][] MATRIX = {
            {1, 2, 3, 4},
            {12, 13, 14, 5},
            {11, 16, 15, 6},
            {10, 9, 8, 7}
    };

    private final Supplier<IntStream> spiralSupplier = new SpiralSupplier(MATRIX);

    @Test
    void spiral() {
        var actual = spiralSupplier.get().toArray();
        var expected = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        assertThat(actual)
                .as("The spiral order of the matrix should be %s", Arrays.toString(expected))
                .isEqualTo(expected);
    }

    @Test
    void fizzBuzz() {
        IntPredicate fizz = i -> i % 3 == 0;
        IntPredicate buzz = i -> i % 5 == 0;

        // TODO: Create a predicate
        IntPredicate fizzBuzz = i -> true;

        var actual = spiralSupplier.get()
                .filter(fizzBuzz)
                .toArray();

        var expected = new int[]{3, 4, 5, 6, 7, 8, 9, 10, 12, 13, 14, 15};

        assertThat(actual)
                .as("The fizz buzz sequence should be %s", Arrays.toString(expected))
                .isEqualTo(expected);
    }
}
