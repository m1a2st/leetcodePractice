package leetcode.easy;

import java.util.Arrays;

public class No3005 {

    class Solution {
        public int maxFrequencyElements(int[] nums) {
            int[] cache = new int[100];
            for (int num : nums) {
                ++cache[num - 1];
            }
            Arrays.sort(cache);
            int maxFreq = Integer.MIN_VALUE;
            int ans = 0;
            for (int i = cache.length - 1; i >= 0; i--) {
                if (maxFreq != Integer.MIN_VALUE) {
                    if (cache[i] != maxFreq) {
                        break;
                    } else {
                        ans += maxFreq;
                    }
                } else {
                    maxFreq = cache[i];
                    ans += maxFreq;
                }
            }
            return ans;
        }
    }
}
