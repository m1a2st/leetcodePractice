package parctice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class No2554 {

    class Solution {
        public int maxCount(int[] banned, int n, int maxSum) {
            int ans = 0;
            int sum = 0;
            Set<Integer> bannedSet = new HashSet<>();
            for (int i : banned) {
                bannedSet.add(i);
            }
            for (int i = 1; i <= n; i++) {
                if (bannedSet.contains(i)) {
                    continue;
                }
                sum += i;
                if (sum > maxSum) {
                    break;
                }
                ans++;
            }
            return ans;
        }
    }
}
