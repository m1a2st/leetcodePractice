package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class No2530 {
    
    @Test
    public void test() {
        Solution solution = new Solution();
        System.out.println(solution.maxKelements(new int[]{10, 10, 10, 10, 10}, 5));
    }

    class Solution {
        public long maxKelements(int[] nums, int k) {
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            for (int num : nums) {
                queue.offer(num);
            }
            long sum = 0;
            for (int i = 0; i < k; i++) {
                Integer num = queue.poll();
                sum += num;
                double ceil = Math.ceil(num / 3.0);
                queue.offer((int) ceil);
            }
            return sum;
        }
    }
}
