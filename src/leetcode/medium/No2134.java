package leetcode.medium;

public class No2134 {

    class Solution {
        public int minSwaps(int[] nums) {
            int onesCount = 0;
            for (int num : nums) {
                onesCount = onesCount + num;
            }
            int n = nums.length, left = 0, right = 0, windowSize = 0;
            // 窗口大小為 0 到 onesCount
            while (right < onesCount) {
                windowSize = windowSize + nums[right % n];
                right++;
            }
            int result = onesCount - windowSize;
            while (right < n + onesCount) {
                windowSize = windowSize + nums[right % n];
                windowSize = windowSize - nums[left % n];
                right++;
                left++;
                result = Math.min(result, onesCount - windowSize);
            }
            return result;
        }
    }
}
