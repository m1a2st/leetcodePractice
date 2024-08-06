package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No3016 {
    
    @Test
    public void test() {
        System.out.println(new Solution().minimumPushes("abcde"));
    }

    class Solution {
        public int minimumPushes(String word) {
            int[] counter = new int[26];
            for (char c : word.toCharArray()) {
                counter[c - 'a']++;
            }
            int ans = 0;
            Arrays.sort(counter);
            for (int i = 0; i < counter.length; i++) {
                ans += counter[26 - i - 1] * ((i / 8) + 1);
            }
            return ans;
        }
    }
}
