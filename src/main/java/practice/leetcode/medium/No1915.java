package practice.leetcode.medium;

public class No1915 {

    class Solution {
        public long wonderfulSubstrings(String word) {
            long res = 0;
            int len = word.length();
            // 因為只有 10 個字母，所以可以用 10 個 bit 來表示是否有出現過
            // 這樣就可以用 1024 個 int 來記錄每個 mask 出現的次數
            int[] count = new int[1024];
            // 一開始沒有任何字母出現，所以 count[0] = 1
            count[0] = 1;
            // mask 用來記錄每個字母出現的次數
            int mask = 0;
            for (int i = 0; i < len; i++) {
                // 每次出現一個字母，就把 mask 的對應 bit 反轉
                // 這樣就可以知道這個字母出現的次數是奇數還是偶數
                // 如果 mask 的第 i 個 bit 是 1，代表第 i 個字母出現奇數次
                mask ^= 1 << (word.charAt(i) - 'a');
                res += count[mask];
                // 這個循環遍歷所有可能出現的字符
                for (int j = 0; j < 10; j++) {
                    res += count[mask ^ (1 << j)];
                }
                count[mask]++;
            }
            return res;
        }
    }
}
