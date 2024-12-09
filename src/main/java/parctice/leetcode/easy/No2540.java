package parctice.leetcode.easy;

public class No2540 {

    class Solution {
        public int getCommon(int[] nums1, int[] nums2) {
            int p1 = 0, p2 = 0;
            int nl1 = nums1.length, nl2 = nums2.length;
            while (p1 < nl1 && p2 < nl2) {
                int n1 = nums1[p1];
                int n2 = nums2[p2];
                if (n1 == n2) {
                    return n1;
                } else if (n1 < n2) {
                    ++p1;
                } else {
                    ++p2;
                }
            }
            while (p1 < nl1) {
                if (nums1[p1] == nums2[nl2 - 1]) {
                    return nums1[p1];
                }
                ++p1;
            }
            while (p2 < nl2) {
                if (nums2[p2] == nums1[nl1 - 1]) {
                    return nums2[p2];
                }
                ++p2;
            }
            return -1;
        }
    }
}
