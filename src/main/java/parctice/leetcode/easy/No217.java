package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author m1a2st
 * @Date 2023/6/3
 * @Version v1.0
 */
public class No217 {

    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                if (!set.add(num)) {
                    return true;
                }
            }
            return false;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        assertTrue(solution.containsDuplicate(nums));
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4};
        assertFalse(solution.containsDuplicate(nums));
    }

}
