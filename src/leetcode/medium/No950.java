package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.LinkedList;

public class No950 {

    @Test
    public void test() {
        new SolutionWorth().deckRevealedIncreasing(new int[]{1, 2, 3, 4, 5});
    }

    class Solution {
        public int[] deckRevealedIncreasing(int[] deck) {
            Arrays.sort(deck);
            int[] res = new int[deck.length];
            Queue<Integer> ans = new LinkedList<>();

            for (int i = 0; i < deck.length; i++) {
                ans.offer(i);
            }

            for (int card : deck) {
                res[ans.poll()] = card;
                if (!ans.isEmpty()) {
                    ans.offer(ans.poll());
                }
            }

            return res;
        }
    }

    class SolutionWorth {
        public int[] deckRevealedIncreasing(int[] deck) {
            Arrays.sort(deck);
            int[] res = new int[deck.length];
            ArrayDeque<Integer> ans = new ArrayDeque<>();
            for (int i = deck.length - 1; i >= 0; i--) {
                List<Integer> list = new LinkedList<>();
                while (ans.size() > 1) {
                    list.add(ans.poll());
                }
                ans.push(deck[i]);
                ans.addAll(list);
            }
            for (int i = 0; i < res.length; i++) {
                res[i] = ans.poll();
            }
            return res;
        }
    }
}

// 1 2 3
// 1 3 2
// 1 2 3 4
// 1 3 2 4
// 1 2 3 4 5
// 1 5 2 4 3
// 1 2 3 4 5 6
// 1 4 2 6 3 5
