package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author m1a2st
 * @Date 2023/3/26
 * @Version v1.0
 */
public class No424 {

    class Solution {
        /**
         * 1. 使用一個 陣列 來記錄每個字元出現的次數
         * 2. 使用兩個指針 left 和 right 來記錄當前子串的左右邊界
         * 3. 計算當前子串中出現次數最多的字元的次數
         * 5. 如果 right - left + 1 - maxCount > k，代表 k 不夠用，需要將 left 指針向右移動
         * 6. 每次移動 right 指針時，更新當前子串的長度
         */
        public int characterReplacement(String s, int k) {
            int ans = 0;
            int maxCount = 0;
            int[] count = new int[26];

            for (int l = 0, r = 0; r < s.length(); ++r) {
                maxCount = Math.max(maxCount, ++count[s.charAt(r) - 'A']);
                while (maxCount + k < r - l + 1) {
                    --count[s.charAt(l++) - 'A'];
                }
                ans = Math.max(ans, r - l + 1);
            }

            return ans;
        }

        /* 滑動窗口算法框架 */
        int slidingWindow(String s, int k) {
            // 用合適的數據結構記錄窗口中的數據
            int[] window = new int[26];
            int maxCount = 0, ans = 0;
            int left = 0, right = 0;
            while (right < s.length()) {
                // c 是將移入窗口的字符
                char c = s.charAt(right);
                // 增大窗口
                right++;
                // 進行窗口內數據的一系列更新
                maxCount = Math.max(maxCount, ++window[c - 'A']);
                /*** debug 輸出的位置 ***/
                // 注意在最終的解法代碼中不要 print
                // 因為 IO 操作很耗時，可能導致超時
                System.out.printf("window: [%d, %d)\n", left, right);
                /********************/

                // 判斷左側窗口是否要收縮
                while (maxCount + k < right - left) {

                    // 縮小窗口
                    left++;
                    // 進行窗口內數據的一系列更新
                    char d = s.charAt(left);
                    maxCount = Math.max(maxCount, --window[d - 'A']);
                }
                // 答案更新
                ans = Math.max(ans, right - left);
            }
            return ans;
        }
    }

    @Test
    public void test() {
        String s = "ABAB";
        int k = 2;
        Solution solution = new Solution();
        int i = solution.slidingWindow(s, k);
        assertEquals(4, i);
    }

    @Test
    public void test2() {
        String s = "AABABBA";
        int k = 1;
        Solution solution = new Solution();
        int i = solution.slidingWindow(s, k);
        assertEquals(4, i);
    }


}
