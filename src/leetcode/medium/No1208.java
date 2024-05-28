package leetcode.medium;

public class No1208 {

    class Solution {
        public int equalSubstring(String s, String t, int maxCost) {
            int len = s.length();
            int[] cost = new int[len];
            for (int i = 0; i < len; i++) {
                cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
            }

            int ans = 0;
            int left = 0, right = 0;
            int sum = 0;
            while (right < len) {
                sum += cost[right];
                while (sum > maxCost) {
                    sum -= cost[left++];
                }
                ans = Math.max(ans, right - left + 1);
                right++;
            }
            return ans;
        }
    }
}
