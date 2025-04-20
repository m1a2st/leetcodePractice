package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    class SolutionNew {
        public int[] deckRevealedIncreasing(int[] deck) {
            Arrays.sort(deck);
            int len = deck.length;
            int[] ans = new int[len];
            ArrayDeque<Integer> cache = new ArrayDeque<>();
            for (int i = 0; i < len; i++) {
                cache.offer(i);
            }
            for (int i : deck) {
                ans[cache.poll()] = i;
                if (!cache.isEmpty()) {
                    cache.offer(cache.poll());
                }
            }
            return ans;
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
