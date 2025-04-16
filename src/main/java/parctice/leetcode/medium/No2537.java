package parctice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class No2537 {

    class Solution {
        public long countGood(int[] nums, int k) {
            long ans = 0;
            int pairs = 0;
            Map<Integer, Integer> count = new HashMap<>();

            for (int l = 0, r = 0; r < nums.length; ++r) {
                // 因為有 count[nums[r]] 個 nums[r]，將 nums[r] 加入窗口會
                // 增加 count[nums[r]] 個好的子數組
                count.put(nums[r], count.getOrDefault(nums[r], 0) + 1);
                pairs += count.get(nums[r]) - 1;

                while (pairs >= k) {
                    count.put(nums[l], count.get(nums[l]) - 1);
                    pairs -= count.get(nums[l]);
                    l++;
                }

                // nums[0..r], nums[1..r], ..., nums[l - 1..r] 是好的子數組，所以加上 l 到 `ans`
                ans += l;
            }

            return ans;
        }
    }
}
