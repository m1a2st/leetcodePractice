package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

    class SolutionNew {
        private List<List<Integer>> res;

        public List<List<Integer>> findWinners(int[][] matches) {
            return new AbstractList<>() {
                @Override
                public int size() {
                    init();
                    return res.size();
                }

                @Override
                public List<Integer> get(int index) {
                    init();
                    return res.get(index);
                }

                private void init() {
                    if (res != null) {
                        return;
                    }
                    res = new ArrayList<>(List.of(new ArrayList<>(), new ArrayList<>()));
                    int max = Integer.MIN_VALUE;
                    for (int[] match : matches) {
                        max = Math.max(max, Math.max(match[0], match[1]));
                    }
                    final boolean[] seen = new boolean[max + 1];
                    for (int[] match : matches) {
                        seen[match[0]] = true;
                        seen[match[1]] = true;
                    }
                    final int[] loserArr = new int[max + 1];
                    for (int[] match : matches) {
                        loserArr[match[1]]++;
                    }
                    for (int i = 1; i <= max; i++) {
                        if (seen[i]) {
                            switch (loserArr[i]) {
                                case 0 -> res.get(0).add(i);
                                case 1 -> res.get(1).add(i);
                            }
                        }
                    }
                }
            };
        }
    }
}
