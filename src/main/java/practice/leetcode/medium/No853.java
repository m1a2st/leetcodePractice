package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @Author m1a2st
 * @Date 2023/6/17
 * @Version v1.0
 */
public class No853 {

    class Solution {
        public int carFleet(int target, int[] position, int[] speed) {
            int ans = 0;
            Car[] cars = new Car[position.length];

            for (int i = 0; i < position.length; ++i) {
                cars[i] = new Car(position[i], (double) (target - position[i]) / speed[i]);
            }

            Arrays.sort(cars, (a, b) -> b.pos - a.pos);

            double maxTime = 0; // The time of the slowest car to reach the target

            for (Car car : cars)
                // A car needs more time to reach the target, so it becomes slowest
                if (car.time > maxTime) {
                    maxTime = car.time;
                    ++ans;
                }

            return ans;
        }

        class Car {
            public int pos;
            public double time;

            public Car(int pos, double time) {
                this.pos = pos;
                this.time = time;
            }
        }
    }


    @Test
    public void Test() {
        Solution solution = new Solution();
        int target = 12;
        int[] position = {10, 8, 0, 5, 3};
        int[] speed = {2, 4, 1, 1, 3};
        assertEquals(solution.carFleet(target, position, speed), 3);
    }

    @Test
    public void Test1() {
        Solution solution = new Solution();
        int target = 100;
        int[] position = {0, 2, 4};
        int[] speed = {4, 2, 4};
        assertEquals(solution.carFleet(target, position, speed), 2);
    }
}



