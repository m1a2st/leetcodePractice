package leecode.medium;

import java.util.Arrays;

public class No33 {


    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) {
                    return mid;
                }
                if (nums[left] < nums[right]) {
                    if (target >= nums[left] && target <= nums[right]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (target >= nums[left] && target <= nums[right]) {
                        right = mid + 1;
                    } else {
                        left = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
