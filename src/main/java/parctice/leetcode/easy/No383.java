package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No383 {

    @Test
    public void test() {
        new Solution().canConstruct("aa", "aab");
    }

    class Solution {
        public boolean canConstruct(String ransomNote, String magazine) {
            int[] cache = new int[26];
            for (char c : magazine.toCharArray()) {
                ++cache[c - 'a'];
            }
            for (char c : ransomNote.toCharArray()) {
                if (--cache[c - 'a'] < 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
