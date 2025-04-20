package practice.leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class No2751 {
    
    @Test
    public void test1() {
        int[] positions = {3, 47};
        int[] healths = {46, 26};
        String directions = "LR";
        System.out.println(new Solution().survivedRobotsHealths(positions, healths, directions));
    }

    class Robot {
        public int index;
        public int position;
        public int health;
        public char direction;
        public Robot(int index, int position, int health, char direction) {
            this.index = index;
            this.position = position;
            this.health = health;
            this.direction = direction;
        }
    }

    class Solution {
        public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
            List<Integer> ans = new ArrayList<>();
            Robot[] robots = new Robot[positions.length];
            List<Robot> stack = new ArrayList<>(); // running robots

            for (int i = 0; i < positions.length; ++i)
                robots[i] = new Robot(i, positions[i], healths[i], directions.charAt(i));

            Arrays.sort(robots, (a, b) -> a.position - b.position);

            for (Robot robot : robots) {
                if (robot.direction == 'R') {
                    stack.add(robot);
                    continue;
                }
                // Collide with robots going right if any.
                while (!stack.isEmpty() && stack.get(stack.size() - 1).direction == 'R' && robot.health > 0) {
                    if (stack.get(stack.size() - 1).health == robot.health) {
                        stack.remove(stack.size() - 1);
                        robot.health = 0;
                    } else if (stack.get(stack.size() - 1).health < robot.health) {
                        stack.remove(stack.size() - 1);
                        robot.health -= 1;
                    } else { // stack[-1].health > robot.health
                        stack.get(stack.size() - 1).health -= 1;
                        robot.health = 0;
                    }
                }
                if (robot.health > 0)
                    stack.add(robot);
            }

            stack.sort(Comparator.comparingInt(a -> a.index));

            for (Robot robot : stack)
                ans.add(robot.health);

            return ans;
        }
    }

    class SolutionWrong {
        public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
            PriorityQueue<Robot> robots = new PriorityQueue<>(Comparator.comparingInt(r -> r.position));
            for (int i = 0; i < positions.length; i++) {
                robots.add(new Robot(positions[i], healths[i], directions.charAt(i)));
            }
            List<Integer> ans = new ArrayList<>();
            Stack<Robot> stack = new Stack<>();
            while (!robots.isEmpty()) {
                stack.push(robots.poll());
                while (stack.size() > 1) {
                    Robot robot1 = stack.pop();
                    Robot robot2 = stack.pop();
                    if (robot1.direction == 'L' && robot2.direction == 'R') {
                        if (robot1.health > robot2.health) {
                            robot1.health--;
                            stack.push(robot1);
                        } else if (robot1.health < robot2.health) {
                            robot2.health--;
                            stack.push(robot2);
                        }
                    } else {
                        stack.push(robot2);
                        stack.push(robot1);
                        break;
                    }
                }
            }
            if (stack.peek().direction == 'R') {
                while (!stack.isEmpty()) {
                    ans.add(stack.pop().health);
                }
            } else {
                while (!stack.isEmpty()) {
                    ans.add(0, stack.pop().health);
                }
            }
            
            return ans;
        }

        class Robot {
            int position;
            int health;
            char direction;

            Robot(int position, int health, char direction) {
                this.position = position;
                this.health = health;
                this.direction = direction;
            }
        }
    }
}
