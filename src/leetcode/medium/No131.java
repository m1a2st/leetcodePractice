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

        List<List<String>> ans = new ArrayList<>();

        public List<List<String>> partition(String s) {
            backTracking(s, 0, new ArrayList<>());
            return ans;
        }

        private void backTracking(String s, int start, ArrayList<String> sub) {
            int len = s.length();
            if (start == len) {
                ans.add(new ArrayList<>(sub));
                return;
            }
            for (int i = start; i < len; i++) {
                if (isPalindrome(s, start, i)) {
                    sub.add(s.substring(start, i + 1));
                    backTracking(s, start + 1, sub);
                    sub.remove(sub.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String s, int start, int end) {
            while (start < end) {
                if (s.charAt(start++) != s.charAt(end--)) {
                    return false;
                }
            }
            return true;
        }
    }
}
