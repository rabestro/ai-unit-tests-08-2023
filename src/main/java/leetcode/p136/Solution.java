package leetcode.p136;

class Solution {
    public int singleNumber(int[] nums) {
        var number = 0;
        for (var num : nums) {
            number ^= num;
        }
        return number;
    }
}
