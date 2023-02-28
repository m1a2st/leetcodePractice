package leecode.easy;

public class No26 {

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums == null) return 0;
            int slow = 0, fast = 0;
            while(fast < nums.length){
                if(nums[slow] == nums[fast]){
                    slow++;
                    nums[slow] = nums[fast];
                }
                fast++;
            }
            return slow + 1;
        }
    }
}
