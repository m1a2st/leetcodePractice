package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class No1590 {

    class Solution {
        public int minSubarray(int[] nums, int p) {
            long sum = 0;
            for (int num : nums) {
                sum += num;
            }
            final int remainder = (int) (sum % p);
            if (remainder == 0)
                return 0;

            int ans = nums.length;
            int prefix = 0;
            Map<Integer, Integer> prefixToIndex = new HashMap<>();
            prefixToIndex.put(0, -1);
            // 計算目標值：`final int target = (prefix - remainder + p) % p;`，
            // 這是為了找到一個前綴和，使得 `(prefix - remainder)` 可以被 `p` 整除。
            // 檢查目標值是否存在於映射中：`if (prefixToIndex.containsKey(target))`，
            // 如果存在，更新最小子數組長度 `ans`。
            // 更新映射：`prefixToIndex.put(prefix, i);`，將當前前綴和及其索引存入映射中。
            for (int i = 0; i < nums.length; ++i) {
                prefix += nums[i];
                prefix %= p;
                final int target = (prefix - remainder + p) % p;
                if (prefixToIndex.containsKey(target))
                    ans = Math.min(ans, i - prefixToIndex.get(target));
                prefixToIndex.put(prefix, i);
            }

            return ans == nums.length ? -1 : ans;
        }
    }
}
