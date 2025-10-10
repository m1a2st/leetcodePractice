package practice.leetcode.medium;

public class No3147 {

    class Solution {
        public int maximumEnergy(int[] energy, int k) {
            int[] temp = new int[energy.length];
            for (int i = 0; i < energy.length; i++) {
                if (i < k) {
                    for (int j = i; j < energy.length; j += k) {
                        temp[i] += energy[j];
                    }
                } else {
                    temp[i] = temp[i - k] - energy[i - k];
                }
            }
            int ans = Integer.MIN_VALUE;
            for (int i : temp) {
                ans = Math.max(ans, i);
            }
            return ans;
        }
    }
}
