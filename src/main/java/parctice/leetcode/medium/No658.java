package parctice.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author m1a2st
 * @Date 2023/4/5
 * @Version v1.0
 */
public class No658 {

    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            List<Integer> ans = new ArrayList<>(k);
            int left = 0, right = arr.length - 1;
            while (right - left >= k) {
                if (Math.abs(arr[right] - x) >= Math.abs(arr[left] - x)) {
                    right++;
                } else {
                    left--;
                }
            }
            for (int i = left; i <= right; i++) {
                ans.add(arr[i]);
            }
            Collections.sort(ans);
            return ans;
        }
    }
}
