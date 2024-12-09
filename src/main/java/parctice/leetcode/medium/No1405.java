package main.java.parctice.leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class No1405 {

    class Solution {
        public String longestDiverseString(int a, int b, int c) {
            Queue<Pair> pq = new PriorityQueue<>(Comparator.comparing(p -> -p.count));
            if (a > 0) pq.add(new Pair('a', a));
            if (b > 0) pq.add(new Pair('b', b));
            if (c > 0) pq.add(new Pair('c', c));
            StringBuilder sb = new StringBuilder();
            while (!pq.isEmpty()) {
                Pair first = pq.poll();
                if (sb.length() >= 2 && sb.charAt(sb.length() - 1) == first.c && sb.charAt(sb.length() - 2) == first.c) {
                    if (pq.isEmpty()) break;
                    Pair second = pq.poll();
                    sb.append(second.c);
                    second.count--;
                    if (second.count > 0) pq.add(second);
                    pq.add(first);
                } else {
                    sb.append(first.c);
                    first.count--;
                    if (first.count > 0) pq.add(first);
                }
            }
            return sb.toString();
        }
        
        class Pair {
            char c;
            int count;
            
            Pair(char c, int count) {
                this.c = c;
                this.count = count;
            }
        }
    }
}
