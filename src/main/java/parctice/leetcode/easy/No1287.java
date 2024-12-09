package main.java.parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No1287 {

    @Test
    public void testFindSpecialInteger() {
        Solution solution = new Solution();
        int[] arr1 = {1, 2, 2, 6, 6, 6, 6, 7, 10};
        int result1 = solution.findSpecialInteger(arr1);
        assert result1 == 6;
        int[] arr2 = {1, 1};
        int result2 = solution.findSpecialInteger(arr2);
        assert result2 == 1;
    }

    class Solution {
        public int findSpecialInteger(int[] arr) {
            int len = arr.length;
            int occurRate = (len / 4) + 1;
            int left = 0, right = 0;
            int sum = 0;
            int ans = 0;
            while (left <= arr.length - occurRate) {
                sum += arr[right];
                if (right - left == occurRate - 1) {
                    if (isTheMostOccurNumber(sum, occurRate, arr[left])) {
                        ans = arr[left];
                    }
                    sum -= arr[left];
                    left++;
                }
                right++;
            }
            return ans;
        }

        private boolean isTheMostOccurNumber(int sum, int occurRate, int target) {
            return target * occurRate == sum;
        }
    }

    class SolutionNew {
        public int findSpecialInteger(int[] arr) {

            int size = arr.length;
            int qtr = size / 4;
            int cnt = 1;

            int p = arr[0];

            for (int i = 1; i < arr.length; i++) {

                if (p == arr[i]) {
                    cnt++;
                } else {
                    cnt = 1;
                }

                if (cnt > qtr) {
                    return arr[i];
                }

                p = arr[i];
            }

            return p;
        }
    }
}
