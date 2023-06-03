package leecode.medium;

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
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int i = 0;
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] != nums[i]) {
                    i++;
                    if (i != j) {
                        nums[i] = nums[j];
                    }
                } else if (i < 1 || nums[j] != nums[i - 1]) {
                    i++;
                    nums[i] = nums[j];
                }
            }
            return i + 1;
        }
    }
}
