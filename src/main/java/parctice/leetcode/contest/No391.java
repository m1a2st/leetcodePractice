package parctice.leetcode.contest;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class No391 {

    class Solution100263 {
        public int sumOfTheDigitsOfHarshadNumber(int x) {
            int temp = x;
            int sum = 0;
            while (temp / 10 != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            sum += temp;
            return x % sum == 0 ? sum : -1;
        }
    }

    @Test
    public void test100235() {
        System.out.println(new Solution100235().maxBottlesDrunk(13, 6));
    }

    class Solution100235 {
        public int maxBottlesDrunk(int numBottles, int numExchange) {
            int ans = numBottles;
            while (numBottles >= numExchange) {
                numBottles -= numExchange;
                ans++;
                numBottles++;
                numExchange++;
            }
            return ans;
        }
    }

    class Solution100266 {
        public long countAlternatingSubarrays(int[] nums) {
            int len = nums.length;
            int[] dp = new int[len];
            dp[0] = 1;
            for (int i = 1; i < len; i++) {
                if (nums[i] != nums[i - 1]) {
                    dp[i] = dp[i - 1] + 1;
                } else {
                    dp[i] = 1;
                }
            }
            long ans = 0;
            for (int i = 0; i < len; i++) {
                ans += dp[i];
            }
            return ans;
        }
    }

    class Solution100240 {
        public int minimumDistance(int[][] points) {
            int len = points.length;
            PriorityQueue<Integer> cache = new PriorityQueue<>();
            for (int i = 0; i < len - 1; i++) {
                int maxDistance = 0;
                maxDistance = Math.max(maxDistance, distance(points[i + 1], points[i]));
                cache.add(maxDistance);
            }
            return cache.peek();
        }


        public int distance(int[] p1, int[] p2) {
            return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
        }
    }
}
