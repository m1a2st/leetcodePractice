package practice.leetcode.medium;

public class No2938 {

    class Solution {
        public long minimumSteps(String s) {
            long res = 0;
            int i = 0;
            int j = 0;
            int n = s.length();
            while (i < n) {
                char cur = s.charAt(i);
                // 遇到白色
                if (cur == '0') {
                    res += i - j;
                    j++;
                }
                i++;
            }
            return res;
        }
    }
}
