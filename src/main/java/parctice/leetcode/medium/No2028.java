package parctice.leetcode.medium;

import java.util.Arrays;

public class No2028 {

    class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            final int targetSum = (rolls.length + n) * mean;
            int missingSum = targetSum - Arrays.stream(rolls).sum();
            if (missingSum > n * 6 || missingSum < n)
                return new int[] {};

            int[] ans = new int[n];
            Arrays.fill(ans, missingSum / n);
            missingSum %= n;
            for (int i = 0; i < missingSum; ++i)
                ++ans[i];

            return ans;
        }
    }
}
