package practice.leetcode.hard;

public class No3068 {

    class Solution {
        public long maximumValueSum(int[] nums, int k, int[][] edges) {
            long maxSum = 0;
            int changedCount = 0;
            int minChangeDiff = Integer.MAX_VALUE;

            for (final int num : nums) {
                int xor = num ^ k;
                maxSum += Math.max(num, xor);
                changedCount += ((xor) > num) ? 1 : 0;
                minChangeDiff = Math.min(minChangeDiff, Math.abs(num - (xor)));
            }

            if (changedCount % 2 == 0) {
                return maxSum;
            }
            return maxSum - minChangeDiff;
        }
    }
}
