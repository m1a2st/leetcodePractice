package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;


public class No1209 {

    @Test
    public void test() {
        System.out.println(new Solution().removeDuplicates("pbbcggttciiippooaais", 2));
    }

    class Item {
        char c;
        int freq;

        public Item(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }

    class Solution {
        public String removeDuplicates(String s, int k) {
            StringBuilder sb = new StringBuilder();
            LinkedList<Item> stack = new LinkedList<>();

            for (final char c : s.toCharArray()) {
                if (!stack.isEmpty() && stack.peek().c == c)
                    ++stack.peek().freq;
                else
                    stack.push(new Item(c, 1));
                if (stack.peek().freq == k)
                    stack.pop();
            }

            while (!stack.isEmpty()) {
                Item item = stack.pop();
                sb.append(String.valueOf(item.c).repeat(Math.max(0, item.freq)));
            }

            return sb.reverse().toString();
        }
    }

}
