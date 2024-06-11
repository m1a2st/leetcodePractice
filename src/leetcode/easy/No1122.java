package leetcode.easy;

public class No1122 {
    class Solution {

        public int[] relativeSortArray(int[] arr1, int[] arr2) {
            int[] ans = new int[arr1.length];
            int index = 0;
            int[] cache = new int[1001];
            for (int num : arr1) {
                cache[num]++;
            }
            for (int num : arr2) {
                int freq = cache[num];
                for (int i = 0; i < freq; ++i) {
                    ans[index++] = num;
                    cache[num]--;
                }
            }
            for (int i = 0; i < 1001; i++) {
                if (cache[i] != 0) {
                    for (int j = 0; j < cache[i]; ++j) {
                        ans[index++] = i;
                    }
                }
            }
            return ans;
        }
    }
}
