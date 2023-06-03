package leecode.medium;

/**
 * @Author m1a2st
 * @Date 2023/3/22
 * @Version v1.0
 */
public class No5 {

    class Solution {
//        public String longestPalindrome(String s) {
//            int point = 1;
//            String[] arr = s.split("");
//            for (int i = 0; i < arr.length; i++) {
//            }
//
//        }

        private boolean isPalindrome(String s) {
            String[] arr = s.split("");
            int left = 0, right = arr.length - 1;
            while(left < right){
                if(arr[left] != arr[right]){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }
    }
}
