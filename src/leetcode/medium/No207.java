package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author m1a2st
 * @Date 2023/8/8
 * @Version v1.0
 */
public class No207 {

    enum State {
        kInit, kVisiting, kVisited
    }

    class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            List<Integer>[] graph = new List[numCourses];
            State[] states = new State[numCourses];

            // 初始化陣列
            for (int i = 0; i < numCourses; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int[] prerequisite : prerequisites) {
                int r = prerequisite[1];
                int pre = prerequisite[0];
                graph[r].add(pre);
            }

            for (int i = 0; i < numCourses; i++) {
                if (hasCycle(graph, i, states)) {
                    return false;
                }
            }
            return true;
        }

        private boolean hasCycle(List<Integer>[] graph, int u, State[] states) {
            if (states[u] == State.kVisiting) return true;
            if (states[u] == State.kVisited) return false;

            states[u] = State.kVisiting;
            for (final int v : graph[u])
                if (hasCycle(graph, v, states))
                    return true;
            states[u] = State.kVisited;

            return false;
        }
    }
}
