package leetcode.easy;

public class No704 {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int search = SolutionOld.search(nums, target);
        System.out.println(search);
    }

    static class SolutionOld {
        public static int search(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }
    }

    class Solution {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                int num = nums[mid];
                if (num == target) {
                    return mid;
                } else if (num > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }

    class SolutionNew {
        public int search(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] > target) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }
    }
}

