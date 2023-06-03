package leecode.easy;

/**
 * @Author m1a2st
 * @Date 2023/4/15
 * @Version v1.0
 */
public class No35 {
    class Solution {
        public int searchInsert(int[] nums, int target) {
            int l = 0;
            int r = nums.length;
            while (l < r) {
                int m = l + (r - l) / 2;
                if (nums[m] == target) {
                    return m;
                }
                if (nums[m] < target) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
            return l;
        }
    }
}
