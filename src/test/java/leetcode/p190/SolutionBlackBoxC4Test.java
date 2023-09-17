package leetcode.p190;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("SolutionBlackBoxC4Test")
class SolutionBlackBoxC4Test {

    private final Solution solution = new Solution();

    static Stream<Arguments> provideTestCasesForReverseBits() {
        return Stream.of(
                Arguments.of("Reverse a random sequence of bits", 43261596, 964176192),
                Arguments.of("Reverse another random sequence of bits", -3, -1073741825),
                Arguments.of("Reverse an integer with maximum number of 1s", -1, -1),
                Arguments.of("Reverse an integer with maximum number of 0s (all bits are 0)", 0, 0),
                Arguments.of("Reverse an integer with alternating 0s and 1s", 1431655765, -1431655766)
        );
    }

    @DisplayName("Test reverseBits")
    @ParameterizedTest(name = "[{index}] {0}")
    @MethodSource("provideTestCasesForReverseBits")
    void testReverseBits(String description, int input, int expectedOutput) {
        var result = solution.reverseBits(input);
        assertThat(result)
                .withFailMessage("Expected reversed bits of %d to be %d, but was %d", input, expectedOutput, result)
                .isEqualTo(expectedOutput);
    }
}
