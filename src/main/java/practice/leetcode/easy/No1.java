package practice.leetcode.easy;

import java.util.HashMap;

public class No1 {

    /**
     * 思路
     * 1. 使用 HashMap 儲存差值與索引
     * 2. 遍歷數組，如果 HashMap 中存在差值，返回差值的索引與當前索引
     * 3. 如果不存在，將當前數組值與索引存入 HashMap
     */
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int diff = target - nums[i];
                if (cache.containsKey(diff)) {
                    return new int[]{cache.get(diff), i};
                } else {
                    cache.put(target, i);
                }
            }
            return new int[]{-1, -1};
        }
    }
}
