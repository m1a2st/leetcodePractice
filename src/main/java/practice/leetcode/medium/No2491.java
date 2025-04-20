package practice.leetcode.medium;

import java.util.Arrays;

public class No2491 {
    
    class Solution {
        public long dividePlayers(int[] skill) {
            Arrays.sort(skill);
            int left = 0;
            int right = skill.length - 1;
            int sum = skill[left] + skill[right];
            long res = 0;
            while (left < right){
                if (skill[left] + skill[right] != sum){
                    return -1;
                }
                else{
                    res += ((long) skill[left] * skill[right]);
                }
                left ++;
                right --;
            }
            return res;
        }
    }
}
