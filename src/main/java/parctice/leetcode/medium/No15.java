package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author m1a2st
 * @Date 2023/3/26
 * @Version v1.0
 */
public class No15 {

    /**
     * 1. 先排序
     * 2. 遍歷數組
     * 3. 雙指針
     * 4. 如果是加起來為0，則加入答案
     * 4.1 指針移動時候要除重複的數字
     * 5. 如果和小於0，則左指針右移
     * 6. 如果和大於0，則右指針左移
     */
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length;
            for (int i = 0; i < len; ++i) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int left = i + 1, right = len - 1;
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] == 0) {
                        ans.add(List.of(nums[i], nums[left++], nums[right--]));
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (nums[i] + nums[left] + nums[right] < 0) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
            return ans;
        }
    }

    @Test
    public void test() {
        // write test here
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }

    @Test
    public void test2() {
        int[] nums = {0, 0, 0};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }

    @Test
    public void test3() {
        int[] nums = {0, 1, 1};
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.threeSum(nums);
        System.out.println(lists);
    }
}
