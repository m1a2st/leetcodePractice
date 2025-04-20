package practice.leetcode.easy;

public class No1550 {
    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            int counter = 0;
            for (int num : arr) {
                if ((num & 1) == 1) {
                    ++counter;
                } else {
                    counter = 0;
                }
                if (counter >= 3) {
                    return true;
                }
            }
            return false;
        }
    }
}
