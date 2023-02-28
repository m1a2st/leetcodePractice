package leecode.hard;

public class No4 {

    public static void main(String[] args) {

    }

//    class Solution {
//        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//            int[] combine = new int[nums1.length + nums2.length];
//            int pointer1 = 0, pointer2 = 0, index = 0;
//            while (pointer1 < nums1.length || pointer2 < nums2.length) {
//                if (nums1[pointer1] >= nums2[pointer2]) {
//                    combine[index] = nums2[pointer2];
//                    pointer2++;
//                } else {
//                    combine[index] = nums1[pointer1];
//                    pointer1++;
//                }
//                index++;
//            }
//            if (pointer1 == nums1.length - 1) {
//                for (int i = pointer2; i < nums2.length; i++) {
//                    combine[index] = nums2[i];
//                    index++;
//                }
//            }
//            if (pointer2 == nums2.length - 1) {
//                for (int i = pointer1; i < nums1.length; i++) {
//                    combine[index] = nums1[i];
//                    index++;
//                }
//            }
//            combine.l
//
//        }
//    }
}
