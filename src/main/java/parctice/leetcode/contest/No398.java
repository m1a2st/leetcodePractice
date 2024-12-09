package main.java.parctice.leetcode.contest;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
            int n = nums.length;
            boolean[] ans = new boolean[queries.length];

            List<Integer> cache = new ArrayList<>();
            cache.add(1);
            int sum = 1;

            for (int i = 0; i < n - 1; i++) {
                if (nums[i] % 2 == nums[i + 1] % 2) {
                    sum += 0;
                } else {
                    sum += 1;
                }
                cache.add(sum);
            }

            for (int i = 0; i < queries.length; i++) {
                int[] q = queries[i];
                int start = q[0];
                int end = q[1];
                int dist = Math.abs(start - end);
                ans[i] = dist == cache.get(end) - cache.get(start);
            }

            return ans;
        }
    }

    @Test
    public void test100300() {
        new Solution100300().sumDigitDifferences(new int[]{13, 23, 12});
    }

    class Solution100300 {
        public long sumDigitDifferences(int[] nums) {
            int len = nums.length;
            int digits = String.valueOf(nums[0]).length();
            int[][] count = new int[digits][10];
            long res = (long) len * (len - 1) / 2 * digits;
            for (int a : nums) {
                for (int i = 0; i < digits && a > 0; i++) {
                    res -= count[i][a % 10]++;
                    a /= 10;
                }
            }
            return res;
        }
    }
}
