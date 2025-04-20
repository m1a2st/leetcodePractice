package practice.leetcode.contest;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

public class No395 {

    class Solution100285 {
        public int addedInteger(int[] nums1, int[] nums2) {
            int sum1 = 0, sum2 = 0;
            for (int num : nums1) {
                sum1 += num;
            }
            for (int num : nums2) {
                sum2 += num;
            }
            return (sum2 - sum1) / nums1.length;
        }
    }

    @Test
    public void test100287() {
        System.out.println(new Solution100287().minimumAddedInteger(new int[]{3, 5, 5, 3}, new int[]{7, 7}));
    }

    class Solution100287 {
        public int minimumAddedInteger(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int size1 = nums1.length;
            HashSet<Integer> cache = new HashSet<>();
            for (int value : nums1) {
                for (int i : nums2) {
                    cache.add(i - value);
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int k : cache) {
                int[] arr = new int[size1];
                for (int i = 0; i < size1; i++) {
                    arr[i] = nums1[i] + k;
                }
                if (check(arr, nums2)) {
                    ans = Math.min(ans, k);
                }
            }
            return ans;
        }

        private boolean check(int[] nums1, int[] nums2) {
            int i = 0, j = 0, val = 2;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] == nums2[j]) {
                    i++;
                    j++;
                } else {
                    i++;
                    val--;
                    if (val < 0) {
                        return false;
                    }
                }
            }
            return j == nums2.length && (i - j) <= 2;
        }
    }
}
