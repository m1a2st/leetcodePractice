package parctice.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class No3396 {

    class Solution {
        public int minimumOperations(int[] nums) {
            Set<Integer> seen = new HashSet<>();
            for (int i = nums.length - 1; i >= 0; --i)
                if (!seen.add(nums[i]))
                    return (i + 1 + 2) / 3; // ceil((i + 1) / 3)
            return 0;
        }
    }
}
