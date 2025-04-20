package practice.leetcode.medium;

public class No540 {

    class Solution {
        public int singleNonDuplicate(int[] nums) {
            int left = 0, right = nums.length - 1;

            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (mid % 2 == 1)
                    --mid;
                if (nums[mid] == nums[mid + 1])
                    left = mid + 2;
                else
                    right = mid;
            }

            return nums[left];
        }
    }
}
