package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No2948 {
    class Solution {
        public int[] lexicographicallySmallestArray(int[] nums, int limit) {
            int n = nums.length;
            int nowAt = 0;
            List<Integer> positions = new ArrayList<>();
            List<Integer> values = new ArrayList<>();
            List<int[]> copied = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                copied.add(new int[]{nums[i], i});
            }

            copied.sort((a, b) -> Integer.compare(a[0], b[0]));
            int previous = copied.get(0)[0];

            while (nowAt < n) {
                if (copied.get(nowAt)[0] - previous <= limit) {
                    positions.add(copied.get(nowAt)[1]);
                    values.add(copied.get(nowAt)[0]);
                    previous = copied.get(nowAt)[0];
                    nowAt++;
                } else {
                    previous = copied.get(nowAt)[0];
                    Collections.sort(values);
                    Collections.sort(positions);
                    for (int i = 0; i < values.size(); i++) {
                        nums[positions.get(i)] = values.get(i);
                    }
                    positions.clear();
                    values.clear();
                }
            }

            Collections.sort(values);
            Collections.sort(positions);
            for (int i = 0; i < values.size(); i++) {
                nums[positions.get(i)] = values.get(i);
            }

            return nums;
        }
    }
}
