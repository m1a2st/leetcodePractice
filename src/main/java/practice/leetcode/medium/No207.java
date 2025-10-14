package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author m1a2st
 * @Date 2023/8/8
 * @Version v1.0
 */
public class No207 {

    class Solution {

        enum State {
            INIT, VISITING, VISITED
        }

        List<List<Integer>> graph = new ArrayList<>();
        State[] states;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
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
                    return false;
                }
            }
            return true;
        }

        private boolean hasCycle(int i) {
            if (states[i] == State.VISITING) {
                return true;
            }

            if (states[i] == State.VISITED) {
                return false;
            }

            states[i] = State.VISITING;
            // dfs
            for (Integer edge : graph.get(i)) {
                if (hasCycle(edge)) {
                    return true;
                }
            }
            states[i] = State.VISITED;
            return false;
        }
    }
}
