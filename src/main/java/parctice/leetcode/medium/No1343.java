package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No1343 {


    @Test
    public void test0() {
        Solution solution = new Solution();
        int[] arr = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;
        System.out.println(solution.numOfSubarrays(arr, k, threshold));
    }

    class Solution {

        int ans = 0;

        public int numOfSubarrays(int[] arr, int k, int threshold) {
            int target = k * threshold;
            int sum = 0;
            int left = 0, right = 0;
            while (right < arr.length) {
                sum += arr[right];
                right++;
                if (right - left == k) {
                    if (sum >= target) {
                        ans++;
                    }
                    sum -= arr[left];
                    left++;
                }
            }
            return ans;
        }
    }

}
