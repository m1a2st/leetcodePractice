package parctice.leetcode.medium;

import java.util.Arrays;

public class No2976 {

    class Solution {
        public long minimumCost(String source,
                                String target,
                                char[] original,
                                char[] changed,
                                int[] cost) {
            long ans = 0;
            
            long[][] dist = new long[26][26];
            // 目前設定為 Long.MAX_VALUE 代表說無法從 i 到 j
            Arrays.stream(dist).forEach(a -> Arrays.fill(a, Long.MAX_VALUE));

            for (int i = 0; i < cost.length; ++i) {
                int u = original[i] - 'a';
                int v = changed[i] - 'a';
                dist[u][v] = Math.min(dist[u][v], cost[i]);
            }
            // floyd-warshall
            for (int k = 0; k < 26; ++k)
                for (int i = 0; i < 26; ++i)
                    if (dist[i][k] < Long.MAX_VALUE)
                        for (int j = 0; j < 26; ++j)
                            if (dist[k][j] < Long.MAX_VALUE)
                                dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);

            for (int i = 0; i < source.length(); ++i) {
                if (source.charAt(i) == target.charAt(i))
                    continue;
                final int u = source.charAt(i) - 'a';
                final int v = target.charAt(i) - 'a';
                if (dist[u][v] == Long.MAX_VALUE)
                    return -1;
                ans += dist[u][v];
            }

            return ans;
        }
    }
}
