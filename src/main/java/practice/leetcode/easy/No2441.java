package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No2441 {

    @Test
    public void test() {
        new Solution().findMaxK(new int[]{-1, 2, -3, 3});
    }

    class Solution {
        public int findMaxK(int[] nums) {
            int[] cache = new int[1001];
            int ans = -1;
            for (int num : nums) {
                int abs = Math.abs(num);
                if (cache[abs] == 0) {
                    if (num > 0) {
                        cache[abs]++;
                    } else {
                        cache[abs]--;
                    }
                } else if (cache[abs] == 1 && num < 0) {
                    ans = Math.max(ans, abs);
                } else if (cache[abs] == -1 && num > 0) {
                    ans = Math.max(ans, abs);
                }
            }
            return ans;
        }
    }
}
