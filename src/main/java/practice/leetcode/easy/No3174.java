package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No3174 {
    
    @Test
    public void Test() {
        Solution solution = new Solution();
        System.out.println(solution.clearDigits("abc"));
    }

    class Solution {
        public String clearDigits(String s) {
            StringBuilder sb = new StringBuilder();
            for (final char c : s.toCharArray())
                if (Character.isDigit(c))
                    sb.setLength(sb.length() - 1);
                else
                    sb.append(c);

            return sb.toString();
        }
    }
}
