package practice.leetcode.medium;

public class No1442 {

    /**
     * 異或運算（^）有以下幾個重要特性：
     * 自反性：a ^ a = 0
     * 交換律：a ^ b = b ^ a
     * 結合律：a ^ (b ^ c) = (a ^ b) ^ c
     */
    class Solution {
        public int countTriplets(int[] arr) {
            int ans = 0;
            int[] pre = new int[arr.length + 1];

            for (int i = 1; i < pre.length; i++) {
                pre[i] = pre[i - 1] ^ arr[i - 1];
            }

            for (int i = 1; i < pre.length; i++) {
                for (int j = i + 1; j < pre.length; j++) {
                    for (int k = j; k < pre.length; k++) {
                        // 題目要求 arr[i] ^ arr[i+1] ^ ... ^ arr[j-1] == arr[j] ^ arr[j+1] ^ ... ^ arr[k]
                        // pre[x] = arr[0] ^ arr[1] ^ ... ^ arr[x-1]
                        // arr[i] ^ arr[i+1] ^ ... ^ arr[j-1] 可以表示為 pre[j] ^ pre[i]
                        // arr[j] ^ arr[j+1] ^ ... ^ arr[k] 可以表示為 pre[k+1] ^ pre[j]
                        // (pre[j] ^ pre[i]) == (pre[k+1] ^ pre[j])，即 pre[i] ==  pre[k+1]
                        // pre[i - 1] ^ pre[j - 1] == pre[j - 1] ^ pre[k]
                        if ((pre[i - 1] ^ pre[j - 1]) == (pre[j - 1] ^ pre[k])) {
                            ans++;
                        }
                    }
                }
            }
            return ans;
        }
    }
}
