package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No387 {

    @Test
    public void test() {
        new Solution().firstUniqChar("aadadaad");
    }

    class Solution {
        public int firstUniqChar(String s) {
            int[] counter = new int[26];
            char[] arr = s.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if (counter[arr[i] - 'a'] > 0) {
                    counter[arr[i] - 'a'] = -1;
                } else if (counter[arr[i] - 'a'] == 0) {
                    counter[arr[i] - 'a'] = i + 1;
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i : counter) {
                if (i > 0 && ans > i) {
                    ans = i;
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans - 1;
        }
    }

    class SolutionNew {
        public int firstUniqChar(String s) {
            int ans = Integer.MAX_VALUE;
            for (char c = 'a'; c <= 'z'; c++) {
                int index = s.indexOf(c);
                if (index != -1 && index == s.lastIndexOf(c)) {
                    ans = Math.min(ans, index);
                }
            }
            return ans == Integer.MAX_VALUE ? -1 : ans;
        }
    }
}
