package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No1002 {

    @Test
    void test() {
        Solution solution = new Solution();
        System.out.println(solution.commonChars(new String[]{"acabcddd", "bcbdbcbd", "baddbadb", "cbdddcac", "aacbcccd", "ccccddda", "cababaab", "addcaccd"}));
    }

    class Solution {
        public List<String> commonChars(String[] words) {
            List<String> ans = new ArrayList<>();
            int[] cache = new int[26];
            Arrays.fill(cache, Integer.MAX_VALUE);

            for (String word : words) {
                int[] count = new int[26];
                for (char c : word.toCharArray()) {
                    ++count[c - 'a'];
                }
                for (int i = 0; i < 26; ++i) {
                    cache[i] = Math.min(cache[i], count[i]);
                }
            }

            for (char c = 'a'; c <= 'z'; ++c) {
                for (int i = 0; i < cache[c - 'a']; ++i) {
                    ans.add(String.valueOf(c));
                }
            }

            return ans;
        }
    }
}
