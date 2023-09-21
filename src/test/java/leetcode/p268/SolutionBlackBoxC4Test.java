package leetcode.p268;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionBlackBoxC4Test {

    private final Solution solution = new Solution();

    @DisplayName("Test missingNumber method:")
    @ParameterizedTest(name = "[{index}] {0}")
    @CsvSource(delimiter = '|', textBlock = """
                    Test case with a small array                 | 3,0,1               | 2
                    Test case with a small array                 | 0,1                 | 2
                    Test case with a larger array                | 9,6,4,2,3,5,7,0,1   | 8
                    Array with only one element                  | 0                   | 1
                    Array with only one element                  | 1                   | 0
                    Array with all elements in ascending order   | 0,1,2,3,4,5,6,8,9   | 7
                    Array with all elements in descending order  | 9,8,7,6,5,4,3,1,0   | 2
            """)
    void testMissingNumber(String description, String input, int expectedOutput) {
        int[] nums = toIntArray(input);
        int result = solution.missingNumber(nums);
        assertThat(result)
                .as("The missing number in the range should be %d", expectedOutput)
                .isEqualTo(expectedOutput);
    }

    private int[] toIntArray(String input) {
        String[] parts = input.split(",");
        int[] nums = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            nums[i] = Integer.parseInt(parts[i]);
        }
        return nums;
    }
}
