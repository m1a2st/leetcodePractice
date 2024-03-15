package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

public class No2225 {


    @Test
    public void test() {
        int[][] matches = {{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
        List<List<Integer>> winners = new Solution().findWinners(matches);
        System.out.println(winners);
    }


    class Solution {
        public List<List<Integer>> findWinners(int[][] matches) {
            List<List<Integer>> ans = Arrays.asList(new ArrayList<>(), new ArrayList<>());
            Map<Integer, Integer> lossesCount = new TreeMap<>();

            for (int[] m : matches) {
                int winner = m[0];
                int loser = m[1];
                if (!lossesCount.containsKey(winner)) {
                    lossesCount.put(winner, 0);
                }
                lossesCount.merge(loser, 1, Integer::sum);
            }

            for (int player : lossesCount.keySet()) {
                int nLosses = lossesCount.get(player);
                if (nLosses < 2) {
                    ans.get(nLosses).add(player);
                }
            }
            return ans;
        }
    }
}
