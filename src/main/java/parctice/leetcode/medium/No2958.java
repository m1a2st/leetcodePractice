package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class No2958 {

    @Test
    public void test() {
        new Solution().maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2);
    }

    class Solution {
        public int maxSubarrayLength(int[] nums, int k) {
            Map<Integer, Integer> cache = new HashMap<>();
            int len = nums.length;
            int left = 0, right = 0;
            int ans = 0;
            int sum = 0;
            while (right < len) {
                int num = nums[right];
                cache.merge(num, 1, Integer::sum);
                sum++;
                while (cache.get(num) > k) {
                    int numL = nums[left];
                    cache.merge(numL, -1, Integer::sum);
                    sum--;
                    left++;
                }
                ans = Math.max(ans, sum);
                right++;
            }
            return ans;
        }
    }
}
