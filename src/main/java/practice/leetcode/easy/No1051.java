package practice.leetcode.easy;

public class No1051 {

    class Solution {
        public int heightChecker(int[] heights) {
            int len = heights.length;
            int[] cache = new int[len];
            System.arraycopy(heights, 0, cache, 0, len);
            int ans = 0;
            for (int i = 0; i < len; ++i) {
                if (cache[i] != heights[i]) {
                    ++ans;
                }
            }
            return ans;
        }
    }
}
