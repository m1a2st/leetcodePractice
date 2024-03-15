package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author m1a2st
 * @Date 2023/7/31
 * @Version v1.0
 */
public class No131 {

    @Test
    public void temp() {
        String s = "aabab";
        Solution solution = new No131().new Solution();
        List<List<String>> partition = solution.partition(s);
        System.out.println(partition);
    }

    class Solution {

        List<List<String>> result = new ArrayList<>();

        public List<List<String>> partition(String s) {
            List<String> list = new ArrayList<>();
            recursive(s, list, 0);
            return result;
        }

        private void recursive(String s, List<String> list, int start) {
            // 終止條件
            if (start == s.length()) {
                result.add(new ArrayList<>(list));
                return;
            }
            for (int i = start; i < s.length(); i++) {
                if (isPalindrome(s, start, i)) {
                    list.add(s.substring(start, i + 1));
                    recursive(s, list, i + 1);
                    list.remove(list.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int l, int r) {
            while (l < r) {
                if (s.charAt(l) != s.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }
}
