package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No1248 {
    
    @Test
    public void test() {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(new Solution().numberOfSubarrays(nums, k));
    }

    class Solution {
        public int numberOfSubarrays(int[] nums, int k) {
            int len = nums.length;
            int[] odd = new int[len + 2];
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (nums[i] % 2 == 1) {
                    odd[++cnt] = i;
                }
            }
            odd[0] = -1;
            odd[++cnt] = len;
            int ans = 0;
            for (int i = 1; i + k <= cnt; i++) {
                ans += (odd[i] - odd[i - 1]) * (odd[i + k] - odd[i + k - 1]);
            }
            return ans;
        }
    }
}
