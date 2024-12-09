package parctice.leetcode.medium;

public class No1578 {

    class Solution {
        public int minCost(String colors, int[] neededTime) {
            int ans = 0;
            int maxNeededTime = neededTime[0];

            for (int i = 1; i < colors.length(); ++i) {
                if (colors.charAt(i) == colors.charAt(i - 1)) {
                    ans += Math.min(maxNeededTime, neededTime[i]);
                    maxNeededTime = Math.max(maxNeededTime, neededTime[i]);
                } else {
                    maxNeededTime = neededTime[i];
                }
            }

            return ans;
        }
    }

    class SolutionNew {
        public int minCost(String colors, int[] neededTime) {
            int ans = 0;
            int maxNeedTime = neededTime[0];
            for (int i = 1; i < colors.length(); i++) {
                if (colors.charAt(i) == colors.charAt(i - 1)) {
                    ans += Math.min(maxNeedTime, neededTime[i]);
                    maxNeedTime = Math.max(maxNeedTime, neededTime[i]);
                } else {
                    maxNeedTime = neededTime[i];
                }
            }
            return ans;
        }
    }
}
