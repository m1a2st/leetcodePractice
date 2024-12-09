package main.java.parctice.lintcode.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No3642 {

    public class Solution {

        public int countElements(int[] arr) {
            Map<Integer, Integer> cache = new HashMap<>();
            int ans = 0;
            for (int i : arr) {
                cache.merge(i + 1, 1, Integer::sum);
            }
            for (int i : arr) {
                if (cache.containsKey(i)) {
                    ans += cache.get(i);
                }
            }
            return ans;
        }
    }

    @Test
    public void test() {
        System.out.println(new SolutionFast().countElements(new int[]{1, 2, 3}));
        System.out.println(new SolutionFast().countElements(new int[]{1, 1, 2, 3}));
        System.out.println(new SolutionFast().countElements(new int[]{1, 3, 5}));
    }

    public class SolutionFast {

        public int countElements(int[] arr) {
            Arrays.sort(arr);
            int len = arr.length;
            int ans = 0;
            int left = 0, right = 0;
            int temp = arr[right];
            while (right < len) {
                if (temp != arr[right]) {
                    if (arr[right] - temp == 1) {
                        ans += right - left + 1;
                    } else {
                        temp = arr[right];
                        left = right;
                    }
                }
                right++;
            }
            return ans;
        }
    }
}
