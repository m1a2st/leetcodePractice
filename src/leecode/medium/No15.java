package leecode.medium;

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
        public List<List<Integer>> threeSum(int[] nums) {
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
    }
}
