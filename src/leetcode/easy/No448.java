package leetcode.easy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No448 {

    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.findDisappearedNumbers(new int[]{3, 2, 1, 1})); // [5,6]
    }

    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            List<Integer> res = new ArrayList<>();
            for (int num : nums) {
                int index = Math.abs(num) - 1;
                nums[index] = -Math.abs(nums[index]);
            }
            for (int i = 0; i < nums.length; ++i) {
                if (nums[i] > 0) {
                    res.add(i + 1);
                }
            }
            return res;
        }
    }
}
