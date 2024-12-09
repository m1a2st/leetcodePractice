package parctice.leetcode.easy;

/**
 * @Author m1a2st
 * @Date 2023/3/28
 * @Version v1.0
 */
public class No1876 {

    public static void main(String[] args) {
        Solution.countGoodSubstrings("aababcabc");
    }

    static class Solution {
        public static int countGoodSubstrings(String s) {
            int count = 0;
            for (int left = 0, right = 3; right <= s.length(); left++, right++) {
                String sub = s.substring(left, right);
                if (isNoDuplicate(sub)) {
                    count++;
                }
            }
            return count;
        }

        private static boolean isNoDuplicate(String sub) {
            char[] chars = sub.toCharArray();
            int left = 0;
            int right = chars.length - 1;
            while (left < right) {
                if (chars[left] == chars[right]) {
                    return false;
                } else if (chars[left] == chars[left + 1]) {
                    return false;
                }
                left++;
            }
            return true;
        }
    }
}
