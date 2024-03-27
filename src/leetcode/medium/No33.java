package leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No33 {


    static class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) {
                    return mid;
                }
                // 一般狀況
                if (nums[left] <= nums[mid]) {
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else {
                    if (nums[mid] <= target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }

            }
            return -1;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        assertEquals(4, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        assertEquals(-1, solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        assertEquals(-1, solution.search(new int[]{1}, 0));
        assertEquals(1, solution.search(new int[]{5, 1, 3}, 1));
        assertEquals(2, solution.search(new int[]{5, 1, 3}, 3));
    }

    class SolutionNew {
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
