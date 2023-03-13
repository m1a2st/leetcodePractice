package leecode.medium;

import java.util.HashMap;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No560 {

    public static void main(String[] args) {
        Solution.subarraySum(new int[]{ 1,2,3,3},3);
    }

    static class Solution {
        public static int subarraySum(int[] nums, int k) {
            HashMap<Integer, Integer> map = new HashMap<>();
            int count = 0;
            int sum = 0;
            map.put(0, 1);
            for (int num : nums) {
                sum += num;
                if (map.containsKey(sum - k)) {
                    count += map.get(sum - k);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
            return count;
        }
    }
}
