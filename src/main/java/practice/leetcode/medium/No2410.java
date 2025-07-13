package practice.leetcode.medium;

import java.util.Arrays;

public class No2410 {

    class Solution {
        public int matchPlayersAndTrainers(int[] players, int[] trainers) {
            int ans = 0;

            Arrays.sort(players);
            Arrays.sort(trainers);

            for (int trainer : trainers)
                if (players[ans] <= trainer && ++ans == players.length)
                    return ans;

            return ans;
        }
    }
}
