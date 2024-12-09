package main.java.parctice.leetcode.easy;

public class No169 {

    class Solution {
        public int majorityElement(int[] nums) {
            int count = 0;
            int candidate = 0;
            for (int num : nums) {
                if (count == 0) {
                    candidate = num;
                }
                count += (num == candidate) ? 1 : -1;
            }
            return candidate;
        }
    }

    class SolutionNew {
        public int majorityElement(int[] nums) {
            int count = 0;
            int ans = 0;
            for (int num : nums) {
                if (count == 0) {
                    ans = num;
                }
                count += (ans == num) ? 1 : -1;
            }
            return ans;
        }
    }


}
