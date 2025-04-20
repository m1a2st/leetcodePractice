package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @Author m1a2st
 * @Date 2023/6/5
 * @Version v1.0
 */
public class No128 {

    class Solution {
        public int longestConsecutive(int[] nums) {
            Arrays.sort(nums);
            int ans = 0;
            int prev = Integer.MAX_VALUE;
            int temp = 0;
            for (int num : nums) {
                if (prev == Integer.MAX_VALUE) {
                    temp++;
                    prev = num;
                } else {
                    if (prev + 1 == num) {
                        temp++;
                        prev = num;
                    } else if (prev != num) {
                        prev = num;
                        ans = Math.max(ans, temp);
                        temp = 1;
                    }
                }
                ans = Math.max(ans, temp);
            }
            return ans;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {100, 4, 200, 1, 3, 2};
        assert solution.longestConsecutive(nums) == 4;
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        assert solution.longestConsecutive(nums) == 7;
    }
}
