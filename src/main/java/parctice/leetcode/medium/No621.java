package parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
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
            // 先計算每一種任務的數量是多少
            int[] counter = new int[26];
            for (char task : tasks) {
                counter[task - 'A']++;
            }
            // 根據數量多寡做排序 7, 6, 5, ...
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i : counter) {
                if (i != 0) {
                    pq.offer(i);
                }
            }

            int result = 0;
            while (!pq.isEmpty()) {
                int oneRound = 0;
                // 這一次可以執行的任務例如說: A:7, B:6, C:5; n = 2
                ArrayList<Integer> taskList = new ArrayList<>();
                // 這邊加入一輪可以接受的任務：ex A, B, C
                for (int i = 0; i <= n; i++) {
                    if (!pq.isEmpty()) {
                        taskList.add(pq.poll());
                        oneRound++;
                    }
                }
                // 把未完成的任務返回 pq 裡面
                // A:6, B:5, C:4
                for (Integer task : taskList) {
                    if (--task > 0) {
                        pq.offer(task);
                    }
                }

                // 如果 pq 裡面為空，代表任務都沒有了，就返回這次做的任務
                // 如果不為空有兩種狀態
                // 1. 任務中間需穿插休息時間
                // 2. 任務中間不需穿插休息時間
                // 但是返回的結果都會是 n + 1
                oneRound = pq.isEmpty() ? oneRound : n + 1;
                result += oneRound;
                // 經過兩輪的任務排序狀態為 A, B, C, A, B, C,... 就會符合題目需求
            }

            return result;
        }
    }

    class SolutionBest {
        public int leastInterval(char[] tasks, int n) {
            int[] charCount = new int[26];
            for (char task : tasks) {
                charCount[task - 'A']++;
            }
            Arrays.sort(charCount);
            int max = charCount[25] - 1;
            int idleSlots = n * max;
            for (int i = 24; i >= 0; i--) {
                idleSlots -= Math.min(charCount[i], max);
            }
            if (idleSlots > 0) {
                return idleSlots + tasks.length;
            }

            return tasks.length;
        }
    }

    @Test
    public void test() {
        BigDecimal bigDecimal = new BigDecimal("0.07");
        System.out.printf("%s%n", bigDecimal);
    }
}
