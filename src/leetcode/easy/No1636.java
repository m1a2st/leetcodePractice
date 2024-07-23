package leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class No1636 {
    
    @Test
    public void test_frequencySort() {
        Solution s = new Solution();
        int[] nums = {1, 1, 2, 2, 2, 3};
        int[] ans = s.frequencySort(nums);
        for (int num : ans)
            System.out.print(num + " ");
    }

    class Solution {
        public int[] frequencySort(int[] nums) {
            Map<Integer, NumFreq> cache = new HashMap<>();
            for (int num : nums) {
                NumFreq nf = cache.getOrDefault(num, new NumFreq(num, 0));
                nf.freq++;
                cache.put(num, nf);
            }
            PriorityQueue<NumFreq> pq = new PriorityQueue<>(cache.values());
            int index = 0;
            while (!pq.isEmpty()) {
                NumFreq numFreq = pq.poll();
                for (int i = 0; i < numFreq.freq; ++i)
                    nums[index++] = numFreq.num;
            }
            return nums;
        }
        
        class NumFreq implements Comparable<NumFreq> {
            int num;
            int freq;
            
            NumFreq(int num, int freq) {
                this.num = num;
                this.freq = freq;
            }

            @Override
            public int compareTo(NumFreq o) {
                if (this.freq == o.freq)
                    return o.num - this.num;
                return this.freq - o.freq;
            }
        } 
    }
}
