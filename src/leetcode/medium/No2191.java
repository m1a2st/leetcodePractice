package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class No2191 {

    @Test
    public void test_sortJumbled() {
        Solution s = new Solution();
        int[] mapping = {8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
        int[] nums = {991, 338, 38};
        int[] ans = s.sortJumbled(mapping, nums);
        for (int num : ans)
            System.out.print(num + " ");
    }

    class Solution {
        public int[] sortJumbled(int[] mapping, int[] nums) {
            Map<Integer, Integer> cache = new HashMap<>();
            for (int i = 0; i < mapping.length; ++i) {
                cache.put(i, mapping[i]);
            }
            PriorityQueue<Num> pq = new PriorityQueue<>();
            for (int i = 0; i < nums.length; i++) {
                int mappingNum = mapping(cache, nums[i]);
                pq.offer(new Num(mappingNum, nums[i], i));
            }
            int index = 0;
            while (!pq.isEmpty()) {
                Num num = pq.poll();
                nums[index++] = num.num;
            }
            return nums;
        }

        private int mapping(Map<Integer, Integer> cache, int num) {
            StringBuilder sb = new StringBuilder();
            if (num == 0) {
                return cache.get(0);
            }
            while (num > 0) {
                int digit = num % 10;
                sb.insert(0, cache.get(digit));
                num /= 10;
            }
            return Integer.parseInt(sb.toString());
        }

        class Num implements Comparable<Num> {
            int mapping;
            int num;
            int index;

            Num(int mapping, int num, int index) {
                this.mapping = mapping;
                this.num = num;
                this.index = index;
            }

            @Override
            public int compareTo(Num o) {
                if (this.mapping == o.mapping)
                    return o.index - this.index;
                return this.mapping - o.mapping;
            }
        }
    }
}
