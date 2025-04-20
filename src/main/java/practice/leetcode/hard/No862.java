package practice.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;

public class No862 {


    class Solution {
        public int shortestSubarray(int[] nums, int k) {
            final int n = nums.length;
            int ans = n + 1;
            Deque<Integer> dq = new ArrayDeque<>();
            long[] prefix = new long[n + 1];

            for (int i = 0; i < n; ++i)
                prefix[i + 1] = (long) nums[i] + prefix[i];
            //	目標: 找到最短的子陣列，使其和至少為 k。
            //	dq.getFirst(): 佇列中存儲的是索引，我們取最早的索引 dq.getFirst()。
            //	prefix[i] - prefix[dq.getFirst()]: 計算從 dq.getFirst() 到 i-1 的區間和。
            //	如果區間和滿足條件 >= k ，則更新 ans 為子陣列長度 i - dq.pollFirst()，並移除該索引，因為它已經不再需要。
            for (int i = 0; i < n + 1; ++i) {
                while (!dq.isEmpty() && prefix[i] - prefix[dq.getFirst()] >= k)
                    ans = Math.min(ans, i - dq.pollFirst());
                // 目標: 保持 dq 中的前綴和是單調遞增的。
                // 如果當前的前綴和 prefix[i] 小於等於佇列尾部的前綴和 prefix[dq.getLast()]，
                // 則移除尾部索引，因為新的前綴和會更有利於滿足條件（更小的前綴和更可能導致較短的子陣列）。
                while (!dq.isEmpty() && prefix[i] <= prefix[dq.getLast()])
                    dq.pollLast();
                dq.addLast(i);
            }

            return ans <= n ? ans : -1;
        }
    }
}
