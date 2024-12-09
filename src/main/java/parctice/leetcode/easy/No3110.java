package parctice.leetcode.easy;

public class No3110 {

    class Solution {
        public int scoreOfString(String s) {
            char[] arr = s.toCharArray();
            int len = arr.length;
            int ans = 0;
            for (int i = 1; i < len; ++i) {
                ans += Math.abs(arr[i] - arr[i - 1]);
            }
            return ans;
        }
    }
}
