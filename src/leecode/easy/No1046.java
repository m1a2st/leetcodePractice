package leecode.easy;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No1046 {

    static class SolutionOld {
        public int lastStoneWeight(int[] stones) {
            Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int stone : stones) {
                pq.add(stone);
            }
            while (pq.size() > 1) {
                int diff = pq.poll() - pq.poll();
                if (diff != 0) {
                    pq.add(diff);
                }
            }
            return pq.size() == 0 ? 0 : pq.poll();
        }
    }

    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int stone : stones) {
                pq.offer(stone);
            }
            while(pq.size() > 1){
                int diff = pq.poll() - pq.poll();
                if(diff != 0){
                    pq.offer(diff);
                }
            }
            return pq.size() == 0 ? 0 : pq.poll();
        }
    }
}
