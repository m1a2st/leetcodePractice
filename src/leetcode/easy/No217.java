package leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                if (map.containsKey(num)) {
                    return true;
                } else {
                    map.put(num, 1);
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
