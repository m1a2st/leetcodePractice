package parctice.leetcode.easy;

public class No1790 {

    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            if (s1.equals(s2)) {
                return true;
            }
            int n = s1.length();
            int count = 0;
            int[] diff = new int[2];
            for (int i = 0; i < n; i++) {
                if (s1.charAt(i) != s2.charAt(i)) {
                    count++;
                    if (count > 2) {
                        return false;
                    }
                    diff[count - 1] = i;
                }
            }
            return count == 2 && s1.charAt(diff[0]) == s2.charAt(diff[1]) && s1.charAt(diff[1]) == s2.charAt(diff[0]);
        }
    }
}
