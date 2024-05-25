package leetcode.medium;

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
            INIT, VISITING, VISITED;
        }

        List<List<Integer>> graph;
        State[] visited;

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            graph = new ArrayList<>();
            visited = new State[numCourses];

            for (int i = 0; i < numCourses; ++i) {
                graph.add(new ArrayList<>());
            }

            for (int[] prerequisite : prerequisites) {
                int start = prerequisite[0];
                int end = prerequisite[1];
                graph.get(start).add(end);
            }

            for (int i = 0; i < numCourses; ++i) {
                if (hasCycle(i)) {
                    return false;
                }
            }
            return true;
        }

        private boolean hasCycle(int start) {
            // 結束條件
            if (visited[start] == State.VISITING) {
                return true;
            }
            if (visited[start] == State.VISITED) {
                return false;
            }

            visited[start] = State.VISITING;
            for (Integer edge : graph.get(start)) {
                if (hasCycle(edge)) {
                    return true;
                }
            }
            visited[start] = State.VISITED;
            return false;
        }
    }
}
