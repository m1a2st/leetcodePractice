package practice.leetcode.medium;

import java.util.Arrays;
import java.util.stream.Collectors;

public class No3487 {

    class Solution {
        public int maxSum(int[] nums) {
            final int mx = Arrays.stream(nums).max().getAsInt();
            if (mx <= 0)
                return mx;
            return Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toSet())
                    .stream()
                    .filter(num -> num > 0)
                    .mapToInt(Integer::intValue)
                    .sum();
        }
    }
}
