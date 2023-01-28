package leecode.medium;

import java.util.Arrays;

public class No153 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int findMin(int[] nums) {
            int ans = 0;
            for (int i = 0; i < nums.length; i++) {
                if(nums[i] > nums[i+1] ){
                    ans =  nums[i+1];
                    break;
                }
            }
            return ans;
        }
    }
}
