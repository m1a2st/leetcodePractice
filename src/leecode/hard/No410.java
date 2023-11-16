package leecode.hard;

import java.util.Arrays;

//類似吃香蕉那題
public class No410 {

    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        Solution solution = new Solution();
        int i = solution.splitArray(nums, k);
        System.out.println(i);
    }

    static class Solution {
        public int splitArray(int[] nums, int k) {
            //如果分成nums.length組，則值為max
            int min = Arrays.stream(nums).max().getAsInt();
            //最大值為分一組
            int max = Arrays.stream(nums).sum();
            while (min < max) {
                int mid = (max - min) / 2 + min;
                if (isMatch(nums, k, mid)) {
                    max = mid;
                } else {
                    min = mid + 1;
                }
            }
            return min;
        }

        public boolean isMatch(int[] nums, int k, int mid) {
            int count = 1;
            int total = 0;
            for (int num : nums) {
                total += num;
                if (total > mid) {
                    count++;
                    total = num;
                }
            }
            return count <= k;
        }
    }

    class SolutionNew {
        public int splitArray(int[] nums, int k) {
            int left = 0, right = 0;
            for (int num : nums) {
                left = Math.max(left, num);
                right += num;
            }
            while (left < right) {
                int mid = (right - left) / 2 + left;
                if (isMatch(nums, k, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        public boolean isMatch(int[] nums, int k, int mid) {
            int count = 1, total = 0;
            for (int num : nums) {
                total += num;
                if (total > mid) {
                    count++;
                    total = num;
                }
            }
            return count <= k;
        }
    }
}
