package leetcode.medium;

import java.util.Arrays;

public class No2601 {

    class Solution {

        public boolean primeSubOperation(int[] nums) {
            int maxElement = getMaxElement(nums);
            // Store the sieve array.
            boolean[] sieve = new boolean[maxElement + 1];
            Arrays.fill(sieve, true);
            sieve[1] = false;
            for (int i = 2; i <= Math.sqrt(maxElement + 1); i++) {
                if (sieve[i]) {
                    for (int j = i * i; j <= maxElement; j += i) {
                        sieve[j] = false;
                    }
                }
            }

            // Start by storing the currValue as 1, and the initial index as 0.
            int currValue = 1;
            int i = 0;
            while (i < nums.length) {
                // Store the difference needed to make nums[i] equal to currValue.
                int difference = nums[i] - currValue;
                // If difference is less than 0, then nums[i] is already less than
                // currValue. Return false in this case.
                if (difference < 0) {
                    return false;
                }
                // If the difference is prime or zero, then nums[i] can be made
                // equal to currValue.
                if (sieve[difference] || difference == 0) {
                    i++;
                } else {
                    // Otherwise, try for the next currValue.
                }
                currValue++;
            }
            return true;
        }

        private int getMaxElement(int[] nums) {
            int max = -1;
            for (int num : nums) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }

    }
}
