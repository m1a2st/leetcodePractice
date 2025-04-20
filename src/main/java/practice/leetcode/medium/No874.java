package practice.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

public class No874 {

    class Solution {
        public int robotSim(int[] commands, int[][] obstacles) {
            int[][] directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int direction = 0;
            int x = 0, y = 0;
            int max = 0;
            Set<String> obstacleSet = new HashSet<>();
            for (int[] obstacle : obstacles) {
                obstacleSet.add(obstacle[0] + "," + obstacle[1]);
            }
            for (int command : commands) {
                if (command == -2) {
                    direction = (direction + 3) % 4;
                } else if (command == -1) {
                    direction = (direction + 1) % 4;
                } else {
                    for (int i = 0; i < command; i++) {
                        int nextX = x + directions[direction][0];
                        int nextY = y + directions[direction][1];
                        if (obstacleSet.contains(nextX + "," + nextY)) {
                            break;
                        }
                        x = nextX;
                        y = nextY;
                        max = Math.max(max, x * x + y * y);
                    }
                }
            }
            return max;
        }
    }
}
