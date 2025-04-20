package practice.leetcode.medium;

public class No1347 {

    class Solution {

        int[] arr = new int[26];

        public int minSteps(String s, String t) {
            for (int i = 0; i < s.length(); i++) {
                arr[s.charAt(i) - 'a']++;
                arr[t.charAt(i) - 'a']--;
            }
            int ans = 0;
            for (int j : arr) {
                if (j > 0) {
                    ans += j;
                }
            }
            return ans;
        }
    }
}
