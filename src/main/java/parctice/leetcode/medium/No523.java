package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No523 {

    @Test
    public void test() {
        SolutionNew solution = new SolutionNew();
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

    class SolutionNew {
        public boolean checkSubarraySum(int[] nums, int k) {
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                sum[i] = sum[i - 1] + nums[i - 1];
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 2; i <= n; i++) {
                set.add(sum[i - 2] % k);
                if (set.contains(sum[i] % k)) return true;
            }
            return false;
        }
    }

}
