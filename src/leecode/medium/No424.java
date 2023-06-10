package leecode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author m1a2st
 * @Date 2023/3/26
 * @Version v1.0
 */
public class No424 {

    class Solution {
        public int characterReplacement(String s, int k) {
            int ans = 0;
            int maxCount = 0;
            int[] count = new int[128];

            for (int l = 0, r = 0; r < s.length(); ++r) {
                maxCount = Math.max(maxCount, ++count[s.charAt(r)]);
                while (maxCount + k < r - l + 1)
                    --count[s.charAt(l++)];
                ans = Math.max(ans, r - l + 1);
            }

            return ans;
        }

        public int characterReplacementNew(String s, int k) {
            int countMax = 0;
            int ans = 0;
            int[] count = new int[26];
            for (int l = 0, r = 0; r < s.length(); r++) {
                char cRight = s.charAt(r);
                countMax = Math.max(countMax, ++count[cRight - 'A']);
                if (countMax + k < r - l + 1) {
                    l++;
                    char cLeft = s.charAt(l);
                    countMax = Math.max(countMax, --count[cLeft - 'A']);
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
