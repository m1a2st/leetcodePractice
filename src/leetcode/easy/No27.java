package leetcode.easy;

/**
 * @Author m1a2st
 * @Date 2023/3/21
 * @Version v1.0
 */
public class No27 {

    public static void main(String[] args) {
        Solution.removeElement(new int[]{3, 2, 2, 3}, 2);
    }

    static class Solution {
        public static int removeElement(int[] nums, int val) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != val) {
                    nums[count] = nums[i];
                    count++;
                }
            }
            return count;
        }
    }

    static class SolutionNew {
        public static int removeElement(int[] nums, int val) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] != val){
                    nums[count] = nums[i];
                    count++;
                }
            }
            return count;
        }
    }
}
