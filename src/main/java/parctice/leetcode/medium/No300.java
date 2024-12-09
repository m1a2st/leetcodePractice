package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No300 {

    @Test
    public void test() {
        System.out.println(new Solution().lengthOfLIS(new int[]{2, 9, 3, 1, 2, 3}));
    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            // tail[i] := the min tail of all increasing subseqs with length i + 1
            // It's easy to see that tail must be an increasing array.
            List<Integer> tail = new ArrayList<>();

            for (final int num : nums)
                if (tail.isEmpty() || num > tail.get(tail.size() - 1))
                    tail.add(num);
                else
                    tail.set(firstGreaterEqual(tail, num), num);

            return tail.size();
        }

        // Finds the first index l s.t a.get(l) >= target.
        // Returns nums.size() if can't find.
        private int firstGreaterEqual(List<Integer> a, int target) {
            int l = 0;
            int r = a.size();
            while (l < r) {
                final int m = (l + r) / 2;
                if (a.get(m) >= target)
                    r = m;
                else
                    l = m + 1;
            }
            return l;
        }
    }

    class SolutionDp {

        int[] dp;

        public int lengthOfLIS(int[] nums) {
            dp = new int[nums.length];
            int res = 0;
            Arrays.fill(dp, 1);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            for (int i : dp) {
                res = Math.max(res, i);
            }
            return res;
        }
    }

    class SolutionDpTwo {

        int[] dp;

        public int lengthOfLIS(int[] nums) {
            dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] > nums[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int res = 0;
            for (int i : dp) {
                res = Math.max(res, i);
            }
            return res;
        }
    }
}
