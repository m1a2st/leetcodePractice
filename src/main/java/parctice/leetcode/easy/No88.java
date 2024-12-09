package main.java.parctice.leetcode.easy;

import java.util.Arrays;

public class No88 {

    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n >= 0)
                System.arraycopy(nums2, 0, nums1, m, n);
            Arrays.sort(nums1);
        }
    }

    class SolutionNew {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int[] res = new int[nums1.length];
            int i1 = 0, i2 = 0;
            int index = 0;
            while (i1 < m && i2 < n) {
                if (nums1[i1] <= nums2[i2]) {
                    res[index++] = nums1[i1++];
                } else {
                    res[index++] = nums2[i2++];
                }
            }

            while (i1 < m) {
                res[index++] = nums1[i1++];
            }

            while (i2 < n) {
                res[index++] = nums2[i2++];
            }

            System.arraycopy(res, 0, nums1, 0, res.length);
        }
    }
}
