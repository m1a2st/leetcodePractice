package practice.leetcode.hard;

import java.util.Arrays;

public class No4 {

    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n1l = nums1.length;
            int n2l = nums2.length;
            int len = n1l + n2l;
            int[] combine = new int[len];
            System.arraycopy(nums1, 0, combine, 0, n1l);
            System.arraycopy(nums2, 0, combine, n1l, n2l);
            Arrays.sort(combine);
            int mid = len / 2;
            return len % 2 == 1 ? combine[mid] : (double) (combine[mid - 1] + combine[mid]) / 2;
        }
    }
}
