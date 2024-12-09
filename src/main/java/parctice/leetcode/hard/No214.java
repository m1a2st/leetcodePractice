package main.java.parctice.leetcode.hard;

import org.junit.jupiter.api.Test;

public class No214 {
    
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.shortestPalindrome("aabc"));
    }
    
    @Test
    public void test2() {
        Solution solution = new Solution();
        System.out.println(solution.shortestPalindrome("abcd"));
    }
    
    class Solution {
        public String shortestPalindrome(String s) {
            final String t = new StringBuilder(s).reverse().toString();
            /*
                這段代碼遍歷反轉後的字串 `t`，檢查 `s` 是否以 `t` 的某個子字串開頭。
                - `t.substring(i)` 會取得 `t` 字串從第 `i` 個字符開始到結尾的子字串。
                - `s.startsWith(t.substring(i))` 檢查 `s` 字串是否以 `t.substring(i)` 開頭。
                
                如果 `s` 以 `t.substring(i)` 開頭，則返回 `t.substring(0, i) + s`，這樣可以構造出一個最短的回文串。
             */
            for (int i = 0; i < t.length(); ++i) {
                if (s.startsWith(t.substring(i))) {
                    return t.substring(0, i) + s;
                }
            }

            return t + s;
        }
    }
}
