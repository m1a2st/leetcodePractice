package practice.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class No2206 {

    class Solution {
        public boolean divideArray(int[] nums) {
            int len = nums.length;
            int numPairs = len / 2;
            int sum = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for(int num : nums){
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            for (Integer value : map.values()) {
                sum += value / 2;
            }
            return sum == numPairs;
        }
    }
}
