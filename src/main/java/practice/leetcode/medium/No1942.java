package practice.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No1942 {

    class Solution {
        public int smallestChair(int[][] times, int targetFriend) {
            int nextUnsatChair = 0;
            PriorityQueue<Integer> emptyChairs = new PriorityQueue<>();
            PriorityQueue<Pair> occupied =
                    new PriorityQueue<>(Comparator.comparing(pair -> pair.key));

            for (int i = 0; i < times.length; ++i) {
                int[] time = times[i];
                time = Arrays.copyOf(time, time.length + 1);
                time[time.length - 1] = i;
                times[i] = time;
            }

            Arrays.sort(times, Comparator.comparingInt(a -> a[0]));

            for (int[] time : times) {
                final int arrival = time[0];
                final int leaving = time[1];
                final int i = time[2];
                while (!occupied.isEmpty() && occupied.peek().key <= arrival)
                    emptyChairs.add(occupied.poll().value);
                if (i == targetFriend)
                    return emptyChairs.isEmpty() ? nextUnsatChair : emptyChairs.peek();
                if (emptyChairs.isEmpty())
                    occupied.add(new Pair(leaving, nextUnsatChair++));
                else
                    occupied.add(new Pair(leaving, emptyChairs.poll()));
            }

            throw new IllegalArgumentException();
        }
    }
    
    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
