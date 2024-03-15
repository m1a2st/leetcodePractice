package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class No2149 {

    class Solution {
        public int[] rearrangeArray(int[] nums) {
            Queue<Integer> positiveArr = new ArrayDeque<>();
            Queue<Integer> negativeArr = new ArrayDeque<>();
            for (int num : nums) {
                if (num > 0) {
                    positiveArr.offer(num);
                } else {
                    negativeArr.offer(num);
                }
            }
            for (int i = 0; i < nums.length; i++) {
                if ((i & 1) == 0) {
                    nums[i] = positiveArr.poll();
                } else {
                    nums[i] = negativeArr.poll();
                }
            }
            return nums;
        }
    }

    class SolutionNew {
        public int[] rearrangeArray(int[] nums) {
            int len = nums.length;
            int[] ans = new int[len];
            int posIndex = 0;
            int negIndex = 0;
            for (int i = 0; i < ans.length; i++) {
                if ((i & 1) == 0) {
                    while (posIndex < len && nums[posIndex] < 0) {
                        posIndex++;
                    }
                    ans[i] = nums[posIndex];
                    posIndex++;
                } else {
                    while (negIndex < len && nums[negIndex] >= 0) {
                        negIndex++;
                    }
                    ans[i] = nums[negIndex];
                    negIndex++;
                }
            }
            return ans;
        }
    }

    class SolutionBest {
        public int[] rearrangeArray(int[] nums) {
            int[] ans = new int[nums.length];
            int posIndex = 0;
            int negIndex = 1;
            for (int num : nums) {
                if (num > 0) {
                    ans[posIndex] = num;
                    posIndex += 2;
                } else {
                    ans[negIndex] = num;
                    negIndex += 2;
                }
            }
            return ans;
        }
    }
}
