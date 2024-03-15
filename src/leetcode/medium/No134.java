package leetcode.medium;

import java.util.Arrays;

public class No134 {

    class Solution {
        public int canCompleteCircuit(int[] gas, int[] cost) {
            int gasses = Arrays.stream(gas).sum();
            int costs = Arrays.stream(cost).sum();
            if(gasses < costs){
                return -1;
            }

            int ans = 0;
            int sum = 0;

            for (int i = 0; i < gas.length; i++) {
                sum += gas[i] - cost[i];
                if(sum < 0){
                    sum = 0;
                    ans = i + 1;
                }
            }
            return ans;
        }
    }
}
