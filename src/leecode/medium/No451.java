package leecode.medium;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class No451 {
    class Solution {
        public String frequencySort(String s) {
            int[] cache = new int[128];
            PriorityQueue<Item> queue = new PriorityQueue<>((i1, i2) -> i2.frequency - i1.frequency);
            StringBuilder ans = new StringBuilder();
            for (char c : s.toCharArray()) {
                ++cache[c];
            }
            for (int i = 0; i < cache.length; i++) {
                queue.offer(new Item((char) (i), cache[i]));
            }
            while (!queue.isEmpty()) {
                Item poll = queue.poll();
                ans.append(String.valueOf(poll.symbol).repeat(Math.max(0, poll.frequency)));
            }
            return ans.toString();
        }

        class Item {
            Character symbol;
            int frequency;

            public Item(Character symbol, int frequency) {
                this.symbol = symbol;
                this.frequency = frequency;
            }
        }
    }

    class SolutionNew {
        public String frequencySort(String s) {
            int[] cache = new int[128];
            TreeSet<Item> items = new TreeSet<>();
            StringBuilder ans = new StringBuilder();
            for (char c : s.toCharArray()) {
                ++cache[c];
            }
            for (int i = 0; i < cache.length; i++) {
                items.add(new Item((char) (i), cache[i]));
            }
            for (Item item : items) {
                ans.append(String.valueOf(item.symbol).repeat(Math.max(0, item.frequency)));
            }
            return ans.toString();
        }
    }

    class Item implements Comparable<Item> {
        Character symbol;
        int frequency;

        public Item(Character symbol, int frequency) {
            this.symbol = symbol;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(Item o) {
            int frequencyComparison = o.frequency - this.frequency;
            if (frequencyComparison == 0) {
                return this.symbol.compareTo(o.symbol);
            }
            return frequencyComparison;
        }
    }
}

