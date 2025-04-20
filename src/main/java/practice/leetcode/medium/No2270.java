package practice.leetcode.medium;

public class No2270 {

    class Solution {
        public int waysToSplitArray(int[] nums) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            int i = 0;
            int ans = 0;
            long n = 0;
            while (i < nums.length - 1) {
                n += nums[i];
                long r = sum - n;

                if (n >= r) {
                    ans++;
                }
                i++;
            }
            return ans;
        }
    }
}
