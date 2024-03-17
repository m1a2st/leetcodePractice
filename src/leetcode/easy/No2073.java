package leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

public class No2073 {

    @Test
    public void test() {
        new Solution().timeRequiredToBuy(new int[]{2, 3, 2}, 2);
    }

    class Solution {
        public int timeRequiredToBuy(int[] tickets, int k) {
            int ans = 0;
            int index = 0;
            while (tickets[k] != 0) {
                if (tickets[index] != 0) {
                    tickets[index]--;
                    ans++;
                }
                index++;
                index %= tickets.length;
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
}
