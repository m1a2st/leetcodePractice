package leetcode.medium;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No523 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {6, 0, 14, 6, 7};
        System.out.println(solution.checkSubarraySum(nums, 7));
    }

    class Solution {
        public boolean checkSubarraySum(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                sum %= k;

                if (sum == 0 && i > 0) {
                    return true;
                }

                if (map.containsKey(sum) && i - map.get(sum) > 1) {
                    return true;
                }
                if (!map.containsKey(sum)) {
                    map.put(sum, i);
                }

            }
            return false;
        }
    }
}
