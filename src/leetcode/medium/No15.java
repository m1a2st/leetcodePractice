package leetcode.medium;

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

    static class Solution {
        public List<List<Integer>> threeSumOld(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            int len = nums.length;
            Arrays.sort(nums);
            for (int left = 0; left < len; left++) {
                //當數字一樣時ex: [-1, -1 , .....]
                if (left > 0 && nums[left] == nums[left - 1]) {
                    continue;
                }
                // 設定左邊為right ，中間數字為mid
                int mid = left + 1, right = len - 1;
                while (mid < right) {
                    if (nums[mid] + nums[right] + nums[left] == 0) {
                        res.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                        mid++;
                        right--;
                        while (mid < right && nums[mid] == nums[mid - 1]) {
                            mid++;
                        }
                        while (mid < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    } else if (nums[mid] + nums[right] + nums[left] < 0) {
                        mid++;
                    } else {
                        right--;
                    }
                }
            }
            return res;
        }

        public List<List<Integer>> threeSum(int[] nums){
            ArrayList<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int len = nums.length;
            for (int left = 0; left < len; left++) {
                if(left > 0 && nums[left] == nums[left - 1]){
                    continue;
                }
                int mid = left + 1, right = len - 1;
                while(mid < right){
                    if(nums[left] + nums[mid] + nums[right] == 0){
                        res.add(Arrays.asList(nums[left], nums[mid], nums[right]));
                        mid++;
                        right--;
                        while(mid < right && nums[mid] == nums[mid - 1]){
                            mid++;
                        }
                        while (mid < right && nums[right] == nums[right + 1]){
                            right--;
                        }
                    }else if(nums[mid] + nums[right] + nums[left] < 0){
                        mid++;
                    }else{
                        right--;
                    }
                }
            }
            return res;
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
