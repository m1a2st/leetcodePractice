package parctice.leetcode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author m1a2st
 * @Date 2023/3/30
 * @Version v1.0
 */
public class No3 {
    /**
     * 1. 使用一個 陣列 來記錄每個字元出現的次數
     * 2. 使用兩個指針 left 和 right 來記錄當前子串的左右邊界
     * 3. 當 right 指針指向的字元出現次數大於 1 時，將 left 指針向右移動，直到當前子串中沒有重複的字元
     * 4. 每次移動 right 指針時，更新當前子串的長度
     * 6. 當 cache 中的字元出現次數大於 1 時，將 left 指針向右移動，直到當前子串中沒有重複的字元
     */
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int ans = 0;
            int tempAns = 0;
            char[] chars = s.toCharArray();
            int[] cache = new int[128];
            int left = 0, right = 0;
            while (right < chars.length) {
                char c = chars[right];
                cache[c]++;
                while(cache[c] == 2) {
                    --tempAns;
                    --cache[chars[left++]];
                }
                tempAns++;
                right++;
                ans = Math.max(ans, tempAns);
            }

            return ans;
        }
    }

    @Test
    public void test() {
        String s = "abcabcbb";
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.lengthOfLongestSubstring(s));
    }

    @Test
    public void test2() {
        String s = "bbbbb";
        Solution solution = new Solution();
        Assertions.assertEquals(1, solution.lengthOfLongestSubstring(s));
    }

    @Test
    public void test3() {
        String s = "pwwkew";
        Solution solution = new Solution();
        Assertions.assertEquals(3, solution.lengthOfLongestSubstring(s));
    }
}
