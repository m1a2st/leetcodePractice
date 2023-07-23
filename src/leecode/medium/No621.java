package leecode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No621 {

    static class Solution {
        public int leastInterval(char[] tasks, int n) {
            int[] array = new int[26];
            for (char task : tasks) {
                array[task - 'A']++;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i : array) {
                if (i != 0) {
                    pq.offer(i);
                }
            }
            int result = 0;
            while (!pq.isEmpty()) {
                int oneRound = 0;
                List<Integer> tasksList = new ArrayList<>();
                for (int i = 0; i <= n; i++) {
                    if (!pq.isEmpty()) {
                        tasksList.add(pq.poll());
                        oneRound++;
                    }
                }
                for (Integer task : tasksList) {
                    if (task - 1 > 0) {
                        pq.offer(task - 1);
                    }
                }
                oneRound = !pq.isEmpty() ? n + 1 : oneRound;
                result += oneRound;
            }
            return result;
        }
    }

    static class SolutionNew {
        public int leastInterval(char[] tasks, int n) {
            int[] temp = new int[26];
            for (char task : tasks) {
                temp[task - 'A']++;
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i : temp) {
                pq.offer(i);
            }
            int result = 0;
            while (!pq.isEmpty()) {
                int oneRound = 0;
                ArrayList<Integer> taskList = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    if (!pq.isEmpty()) {
                        taskList.add(pq.poll());
                        oneRound++;
                    }
                }
                for (Integer task : taskList) {
                    if (task - 1 > 0) {
                        pq.offer(task - 1);
                    }
                }
                oneRound = !pq.isEmpty() ? n + 1 : oneRound;
                result += oneRound;
            }
            return result;
        }
    }
}
