package practice.leetcode.medium;

public class No2134 {

    class Solution {
        public int minSwaps(int[] nums) {
            int onesCount = 0;
            for (int num : nums) {
                onesCount += num;
            }
            int len = nums.length;
            int left = 0;
            int right = 0;
            int windowOnesCount = 0;
            while (right < onesCount) {
                windowOnesCount += nums[right++];
            }
            int ans = onesCount - windowOnesCount;
            while (right < len + onesCount) {
                windowOnesCount += nums[right++ % len];
                windowOnesCount -= nums[left++ % len];
                ans = Math.min(ans, onesCount - windowOnesCount);
            }
            return ans;
        }
    }
}
