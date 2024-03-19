package leetcode.medium;

import java.util.Arrays;

public class No950 {

    // TODO not completed
    class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            Arrays.sort(deck);
            int[] res = new int[deck.length];
            int di = 0;
            for (int i = 0; i < res.length; i += 2) {
                res[i] = deck[di++];
            }
            return res;
        }
    }
}
