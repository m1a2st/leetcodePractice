package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No179 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {3, 30, 34, 5, 9, 0};
        System.out.println(solution.largestNumber(nums));
    }

    class Solution {
        public String largestNumber(int[] nums) {
            String[] strNums = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strNums[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));
            if (strNums[0].equals("0")) {
                return "0";
            }
            StringBuilder ans = new StringBuilder();
            for (String strNum : strNums) {
                ans.append(strNum);
            }
            return ans.toString();
        }
    }
}
