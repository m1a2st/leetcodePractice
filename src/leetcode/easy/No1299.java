package leetcode.easy;

public class No1299 {

    class Solution {
        public int[] replaceElements(int[] arr) {
            int len = arr.length;
            int[] ans = new int[len];
            for (int i = 0; i < len - 1; i++) {
                int max = arr[i + 1];
                for (int j = i + 1; j < len; j++) {
                    max = Math.max(max, arr[j]);
                }
                ans[i] = max;
            }
            ans[len - 1] = -1;
            return ans;
        }
    }

    class SolutionNew {
        public int[] replaceElements(int[] arr) {
            int len = arr.length;
            int maxRight = -1;
            for (int i = len - 1; i >= 0; i--) {
                int a = arr[i];
                arr[i] = maxRight;
                maxRight = Math.max(maxRight, a);

            }
            return arr;
        }
    }
}
