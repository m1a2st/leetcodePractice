package practice.leetcode.medium;

public class No2874 {

    class Solution {
        // Same as 2873. Maximum Value of an Ordered Triplet I
        public long maximumTripletValue(int[] nums) {
            long ans = 0;
            int maxDiff = 0; // max(nums[i] - nums[j])
            int maxNum = 0;  // max(nums[i])

            for (final int num : nums) {
                ans = Math.max(ans, (long) maxDiff * num); // num := nums[k]
                maxDiff = Math.max(maxDiff, maxNum - num); // num := nums[j]
                maxNum = Math.max(maxNum, num);            // num := nums[i]
            }

            return ans;
        }
    }
}
