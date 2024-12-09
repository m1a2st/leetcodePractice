package parctice.leetcode.medium;

public class No1310 {

    class Solution {
        public int[] xorQueries(int[] arr, int[][] queries) {
            int[] ans = new int[queries.length];
            int[] xor = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                xor[i + 1] = xor[i] ^ arr[i];
            }
            for (int i = 0; i < queries.length; i++) {
                ans[i] = xor[queries[i][0]] ^ xor[queries[i][1] + 1];
            }
            return ans;
        }
    }
}
