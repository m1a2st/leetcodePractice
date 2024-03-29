package leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No2962 {


    class Solution {
        public long countSubarrays(int[] nums, int k) {
            long res = 0;
            int max = 0, count = 0;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            int l = 0;
            for (int num : nums) {
                if (num == max) {
                    count++;
                }
                while (count >= k) {
                    if (nums[l++] == max) {
                        count--;
                    }
                }
                res += l;
            }
            return res;
        }
    }
}
