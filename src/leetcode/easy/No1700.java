package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class No1700 {

    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            int[] count = new int[2];
            for (int student : students) {
                count[student]++;
            }
            for (int sandwich : sandwiches) {
                if (count[sandwich] == 0) {
                    break;
                }
                count[sandwich]--;
            }
            return count[0] + count[1];
        }
    }

    class SolutionTest {
        public int countStudents(int[] students, int[] sandwiches) {
            Queue<Integer> queue = new LinkedList<>();
            Queue<Integer> food = new LinkedList<>();

            for (int i = 0; i < students.length; i++) {
                queue.offer(students[i]);
                food.offer(sandwiches[i]);
            }

            int count = students.length;
            while (count > 0 && !queue.isEmpty()) {
                int student = queue.poll();
                int sandwich = food.peek();
                if (student != sandwich) {
                    queue.offer(student);
                    count--;
                } else {
                    food.poll();
                    count = queue.size();
                }
            }
            return queue.size();
        }
    }
}
