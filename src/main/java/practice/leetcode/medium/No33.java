package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No33 {

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, solution.search(new int[]{1}, 0));
        assertEquals(1, solution.search(new int[]{5, 1, 3}, 1));
        assertEquals(2, solution.search(new int[]{5, 1, 3}, 3));
    }

    /**
     * 1. 如果 nums[left] <= nums[mid]，則左半部分有序
     * 2. 如果 nums[left] <= target <= nums[mid]，則 target 在左半部分，移動右指針
     * 3. 反之，移動左指針
     * 4. 如果 nums[left] > nums[mid]，則右半部分有序
     * 5. 如果 nums[mid] <= target <= nums[right]，則 target 在右半部分，移動左指針
     * 6. 反之，移動右指針
     */
    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) {
                    return mid;
                }
                // target = 2
                // [1, 2, 3, 4, 5]
                // [3, 4, 5, 1, 2]
                if (nums[left] <= nums[mid]) {
                    // [1, 2, 3, 4, 5]
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                    // [5, 1, 2, 3, 4]
                    // [4, 5, 1, 2, 3]
                } else {
                    if (nums[mid] <= target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
            }
            return -1;
        }
    }

}
