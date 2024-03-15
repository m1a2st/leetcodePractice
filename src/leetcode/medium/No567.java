package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author m1a2st
 * @Date 2023/6/11
 * @Version v1.0
 */
public class No567 {

    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int len2 = s2.length();
            int len1 = s1.length();
            // 窗口大小固定為s1的長度
            Map<Character, Integer> count = new HashMap<>(len1);
            int left = 0, right = 0;
            while (right < len2) {
                // 取出right的值
                char r = s2.charAt(right);
                // 放進windows 裡面
                count.put(r, count.getOrDefault(r, 0) + 1);
                // 移動左指針
                right++;
                System.out.printf("window: [%d, %d)\n", left, right);
                // 當窗口大小為 s1 長度時
                if (right - left == len1) {
                    // 判斷是否為相同字串
                    if (checkStringIsValid(count, s1)) {
                        return true;
                    }
                    // 把左只真的值移出window
                    char l = s2.charAt(left);
                    count.put(l, count.get(l) - 1);
                    // 若為0時則移出window
                    if (count.get(l) == 0) {
                        count.remove(l);
                    }
                    left++;
                }

            }
            // 不是的話遍歷完，回傳false
            return false;
        }

        private boolean checkStringIsValid(Map<Character, Integer> count, String s1) {
            Map<Character, Integer> copy = new HashMap<>(count);
            for (int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                if (copy.containsKey(c)) {
                    copy.put(c, copy.get(c) - 1);
                    if (copy.get(c) == 0) {
                        copy.remove(c);
                    }
                } else {
                    return false;
                }
            }
            return copy.size() == 0;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        assertTrue(solution.checkInclusion("ab", "eidbaooo"));
    }

    @Test
    public void test2() {
        SolutionGood solution = new SolutionGood();
        assertFalse(solution.checkInclusion("ab", "eidboaoo"));
    }

    class SolutionGood {
        public boolean checkInclusion(String s1, String s2) {
            int[] count = new int[26];
            int required = s1.length();

            // 將所有欲比對的字串加入window
            for (final char c : s1.toCharArray())
                ++count[c - 'a'];

            for (int l = 0, r = 0; r < s2.length(); ++r) {
                if (--count[s2.charAt(r) - 'a'] >= 0)
                    --required;
                while (required == 0) {
                    // 判斷字元是否連續，若是連續的為true
                    if (r - l + 1 == s1.length())
                        return true;
                    // 把原先過濾的字元回填回去，若回填的字母釋出現在s1的那麼此字母就會大於0
                    if (++count[s2.charAt(l++) - 'a'] > 0)
                        //所以s1長度要加回去
                        ++required;
                }
            }

            return false;
        }
    }
}
