package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No3186 {

    class Solution {
        public long maximumTotalDamage(int[] power) {
            // 統計每個傷害值的總和
            Map<Integer, Long> damageCount = new HashMap<>();
            for (int p : power) {
                damageCount.put(p, damageCount.getOrDefault(p, 0L) + p);
            }

            // 取得所有不同的傷害值並排序
            List<Integer> uniquePowers = new ArrayList<>(damageCount.keySet());
            Collections.sort(uniquePowers);

            int n = uniquePowers.size();
            if (n == 0) return 0;
            if (n == 1) return damageCount.get(uniquePowers.get(0));

            // dp[i] 表示考慮前 i 個傷害值時的最大總傷害
            long[] dp = new long[n];
            dp[0] = damageCount.get(uniquePowers.get(0));

            for (int i = 1; i < n; i++) {
                int currentPower = uniquePowers.get(i);
                long currentDamage = damageCount.get(currentPower);

                // 選項1: 不選擇當前傷害值
                dp[i] = dp[i - 1];

                // 選項2: 選擇當前傷害值
                // 需要找到最後一個可以共存的傷害值位置
                long takeCurrentDamage = currentDamage;

                // 找到第一個 < currentPower - 2 的位置
                int j = i - 1;
                while (j >= 0 && uniquePowers.get(j) >= currentPower - 2) {
                    j--;
                }

                if (j >= 0) {
                    takeCurrentDamage += dp[j];
                }

                dp[i] = Math.max(dp[i], takeCurrentDamage);
            }

            return dp[n - 1];
        }
    }
}
