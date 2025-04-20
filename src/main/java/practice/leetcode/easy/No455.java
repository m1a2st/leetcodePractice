package practice.leetcode.easy;

import java.util.Arrays;

public class No455 {

    class Solution {
        public int findContentChildren(int[] g, int[] s) {
            int count = 0;
            Arrays.sort(g);
            Arrays.sort(s);
            int i = 0, j = 0;
            int n = g.length, m = s.length;
            while (i < n && j < m) {
                if (g[i] <= s[j]) {
                    count++;
                    i++;
                }
                j++;
            }
            return count;
        }
    }
}
