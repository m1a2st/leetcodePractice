package leetcode.medium;

import org.junit.Test;

import java.util.Arrays;

public class No179 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(solution.largestNumber(nums));
    }

    class Solution {
        public String largestNumber(int[] nums) {
            String[] strNums = new String[nums.length];
            for (int i = 0; i < nums.length; i++) {
                strNums[i] = String.valueOf(nums[i]);
            }
            Arrays.sort(strNums, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
            if (strNums[0].equals("0")) {
                return "0";
            }
            StringBuilder sb = new StringBuilder();
            for (String strNum : strNums) {
                sb.append(strNum);
            }
            return sb.toString();
        }
    }
}
