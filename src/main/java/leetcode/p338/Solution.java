package leetcode.p338;

import java.util.stream.IntStream;

class Solution {
    public int[] countBits(int n) {
        return IntStream.rangeClosed(0, n)
                .map(Integer::bitCount)
                .toArray();
    }
}
