package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class No525 {

    @Test
    public void test() {
        new Solution().findMaxLength(new int[]{0, 1, 0, 1, 0, 1, 0, 0, 1, 1});
    }

    class Solution {
        public int findMaxLength(int[] nums) {
            //sum, index
            Map<Integer, Integer> map = new HashMap<>();
            int cur = 0;
            int ans = 0;
            map.put(0, -1);
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) {
                    cur -= 1;
                } else {
                    cur += 1;
                }
                if (!map.containsKey(cur)) {
                    map.put(cur, i);
                } else {
                    ans = Math.max(ans, i - map.get(cur));
                }
            }
            return ans;
        }
    }
}
