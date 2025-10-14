package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class No210 {

    @Test
    public void test() {
        int numCourses = 4;
        int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
        System.out.println(new Solution().findOrder(numCourses, prerequisites));
    }

    class Solution {

        enum State {
            INIT, VISITING, VISITED
        }

        List<List<Integer>> graph = new ArrayList<>();
        State[] states;
        List<Integer> topologicalOrder = new ArrayList<>();

        // prerequisites = [[1,0], [2,0], [3,1], [3,2]]
        // 0 -> 1, 2
        // 1 -> 3
        // 2 -> 3
        // 3
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            states = new State[numCourses];
            for (int i = 0; i < numCourses; i++) {
                graph.add(new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                int start = prerequisite[0];
                int end = prerequisite[1];
                graph.get(end).add(start);
            }

            for (int i = 0; i < numCourses; i++) {
                if (hasCycle(i)) {
                    return new int[0];
                }
            }
            int[] res = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                res[i] = topologicalOrder.get(numCourses - 1 - i);
            }
            return res;
        }

        private boolean hasCycle(int i) {
            if (states[i] == State.VISITING) {
                return true;
            }

            if (states[i] == State.VISITED) {
                return false;
            }

            states[i] = State.VISITING;
            for (Integer integer : graph.get(i)) {
                if (hasCycle(integer)) {
                    return true;
                }
            }
            topologicalOrder.add(i);
            states[i] = State.VISITED;
            return false;
        }
    }
}
