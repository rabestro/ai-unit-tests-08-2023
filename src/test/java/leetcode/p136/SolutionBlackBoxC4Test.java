package leetcode.p136;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import java.util.stream.Stream;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.Assertions.*;

class SolutionBlackBoxC4Test {
    static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[]{2, 2, 1}, 1, "Most Common Case"),
                Arguments.of(new int[]{1}, 1, "Minimum Elements"),
                Arguments.of(new int[]{4, 1, 2, 1, 2}, 4, "Middle Element is the Single One"),
                Arguments.of(new int[]{10000, -10000, -10000}, 10000, "Large Numbers")
        );
    }

    @DisplayName("Single Number Test:")
    @ParameterizedTest(name = "[{index}] {2}")
    @MethodSource("testCases")
    void singleNumberTest(int[] nums, int expectedSingleNumber, String description) {
        var testCaseSolution = new Solution();
        var result = testCaseSolution.singleNumber(nums);

        assertThat(result)
                .as("%s: In the array %s, the number that does not appear twice is %s", description, nums, expectedSingleNumber)
                .isEqualTo(expectedSingleNumber);
    }
}
