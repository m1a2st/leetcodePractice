package leetcode.contest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class No398 {

    class Solution100310 {
        public boolean isArraySpecial(int[] nums) {
            if (nums.length == 0) {
                return true;
            }
            int checker = 0;
            for (int num : nums) {
                if (checker == 0) {
                    if ((num & 1) == 1) {
                        checker = -1;
                    } else {
                        checker = 1;
                    }
                } else {
                    if ((num & 1) == 1) {
                        if (checker == 1) {
                            checker = -1;
                        } else {
                            return false;
                        }
                    } else {
                        if (checker == -1) {
                            checker = 1;
                        } else {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }

    @Test
    public void test() {
        new Solution().isArraySpecial(new int[]{4, 3, 1, 6}, new int[][]{{0, 2}, {2, 3}});
    }

    class Solution {
        public boolean[] isArraySpecial(int[] nums, int[][] queries) {
            return null;
        }
    }

    @Test
    public void test100300() {
        new Solution100300().sumDigitDifferences(new int[]{13, 23, 12});
    }

    class Solution100300 {
        public long sumDigitDifferences(int[] nums) {
            int n = nums.length;

            // Determine the number of digits in each number
            int numDigits = String.valueOf(nums[0]).length();

            // Create a 2D list to count digits at each position
            int[][] digitCount = new int[numDigits][10];

            // Fill the digit count array
            for (int num : nums) {
                String numStr = String.valueOf(num);
                for (int i = 0; i < numDigits; i++) {
                    digitCount[i][numStr.charAt(i) - '0']++;
                }
            }

            // Calculate the sum of digit differences
            int totalDifference = 0;
            for (int i = 0; i < numDigits; i++) {
                for (int d = 0; d < 10; d++) {
                    int count = digitCount[i][d];
                    totalDifference += count * (n - count) / 2;
                }
            }

            return totalDifference;
        }
    }
}
