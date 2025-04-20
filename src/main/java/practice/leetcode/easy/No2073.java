package practice.leetcode.easy;

import org.junit.jupiter.api.Test;

public class No2073 {

    @Test
    public void test() {
        new Solution().timeRequiredToBuy(new int[]{2, 3, 2}, 2);
    }

    class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int len = tickets.length;
            int ans = 0;
            int index = 0;
            while (tickets[k] != 0) {
                if (tickets[index %= len] != 0) {
                    tickets[index]--;
                    ans++;
                }
                index++;
            }
            return ans;
        }
    }

    class SolutionBest {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int seconds = 0;
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] < tickets[k]) {
                    seconds += tickets[i]; // only add the time needed to buy his tickets
                } else {
                    if (i <= k) {
                        seconds += tickets[k];
                    } else {
                        seconds += tickets[k] - 1;
                    }
                }
            }
            return seconds;
        }
    }

    class SolutionP {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int ans = 0;
            int limit = tickets[k];
            for (int i = 0; i < tickets.length; i++) {
                if (tickets[i] < limit) {
                    ans += tickets[i];
                } else {
                    if (i <= k) {
                        ans += limit;
                    } else {
                        ans += limit - 1;
                    }
                }
            }
            return ans;
        }
    }
}
