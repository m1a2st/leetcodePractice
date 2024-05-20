package leetcode.easy;

public class No1614 {

    class Solution {

        public int maxDepth(String s) {
            int ans = 0;
            int sum = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    sum++;
                } else if (c == ')') {
                    ans = Math.max(ans, sum);
                    sum--;
                }
            }

            return ans;
        }
    }
}
