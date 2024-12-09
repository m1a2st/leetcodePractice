package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author m1a2st
 * @Date 2023/7/3
 * @Version v1.0
 */
public class No287 {

    class Solution {
        public int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[nums[0]];

            while (slow != fast) {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            slow = 0;
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = solution.findDuplicate(nums);
        assertEquals(2, duplicate);
    }

    @Test
    public void test2() {
        Solution solution = new Solution();
        int[] nums = {3, 1, 3, 4, 2};
        int duplicate = solution.findDuplicate(nums);
        assertEquals(3, duplicate);
    }

    class SolutionSpaceWrong {
        public int findDuplicate(int[] nums) {
            boolean[] visited = new boolean[nums.length + 1];
            for (int num : nums) {
                if (visited[num]) {
                    return num;
                }
                visited[num] = true;
            }
            return -1;
        }
    }

    class SolutionNew {
        public int findDuplicate(int[] nums) {
            int slow = nums[0];
            int fast = nums[0];

            do {
                slow = nums[slow];
                fast = nums[nums[fast]];
            } while (slow != fast);

            slow = nums[0];
            while (slow != fast) {
                slow = nums[slow];
                fast = nums[fast];
            }
            return slow;
        }
    }
}
