package leecode.hard;

import java.util.*;

public class No2402 {

    class Solution {
        public int mostBooked(int n, int[][] meetings) {
            Arrays.sort(meetings, (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
            int[] count = new int[n];
            PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]));
            PriorityQueue<Integer> idles = new PriorityQueue<>();
            for (int i = 0; i < n; i++) {
                idles.add(i);
            }
            for (int[] meeting : meetings) {
                while (!pq.isEmpty() && pq.peek()[0] <= meeting[0]) {
                    long[] tmp = pq.poll();
                    idles.add((int) tmp[1]);
                }
                if (!idles.isEmpty()) {
                    int room = idles.poll();
                    count[room]++;
                    pq.add(new long[]{meeting[1], room});
                } else {
                    long[] room = pq.poll();
                    count[(int) room[1]]++;
                    room[0] += meeting[1] - meeting[0];
                    pq.add(room);
                }
            }
            int max = 0;
            int res = 0;
            for (int i = 0; i < n; i++) {
                if (max < count[i]) {
                    res = i;
                    max = count[i];
                }
            }
            return res;
        }
    }
}
