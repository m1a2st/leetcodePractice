package leecode.easy;

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
            for (int low = 0, fast = 1; fast < nums.length; ) {
                if (nums[low] == val) {
                    if (nums[fast] != val) {
                        swap(nums, low, fast);
                        low++;
                    }
                    fast++;
                } else {

                }
            }
            return 0;
        }

        private static void swap(int[] nums, int low, int fast) {
            int t = nums[low];
            nums[low] = nums[fast];
            nums[fast] = t;
        }
    }
}
