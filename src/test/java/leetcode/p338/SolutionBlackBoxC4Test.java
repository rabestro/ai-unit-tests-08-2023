package leetcode.p338;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;

class SolutionBlackBoxC4Test {

    @DisplayName("countBits tests")
    @ParameterizedTest(name = "#{index} - Test with n = {0}")
    @MethodSource("provideTestData")
    void countBitsTest(int n, int[] expected) {
        var solution = new Solution();
        assertThat(solution.countBits(n)).isEqualTo(expected);
    }
    
    private static Stream<Object[]> provideTestData() {
        return Stream.of(
                new Object[]{0, new int[]{0}},
                new Object[]{1, new int[]{0, 1}},
                new Object[]{2, new int[]{0, 1, 1}},
                new Object[]{5, new int[]{0, 1, 1, 2, 1, 2}}
        );
    }

}
