package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

/**
 * @Author m1a2st
 * @Date 2023/3/26
 * @Version v1.0
 */
public class No80 {

    public static void main(String[] args) {
        Solution.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});
    }

    static class Solution {
        public static int removeDuplicates(int[] nums) {
            int slow = 0;
            for (int fast = 1; fast < nums.length; fast++) {
                if (nums[fast] != nums[slow]) {
                    slow++;
                    if (slow != fast) {
                        nums[slow] = nums[fast];
                    }
                } else if (slow < 1 || nums[fast] != nums[slow - 1]) {
                    slow++;
                    nums[slow] = nums[fast];
                }
            }
            return slow + 1;
        }
    }

    @Test
    public void test() {
        SolutionNew solutionNew = new SolutionNew();
        solutionNew.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});
    }

    class SolutionNew {
        public int removeDuplicates(int[] nums) {
            int i = 0;

            for (final int num : nums)
                if (i < 2 || num > nums[i - 2])
                    nums[i++] = num;

            return i;
        }
    }

}
