package main.java.parctice.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class No1700 {

    class Solution {
        public int countStudents(int[] students, int[] sandwiches) {
            int[] counter = new int[2];
            for (int student : students) {
                ++counter[student];
            }
            for (int sandwich : sandwiches) {
                if (counter[sandwich] > 0) {
                    counter[sandwich]--;
                } else {
                    break;
                }
            }
            return counter[0] + counter[1];
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
