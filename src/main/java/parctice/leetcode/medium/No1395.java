package parctice.leetcode.medium;

public class No1395 {

    class Solution {
        public int numTeams(int[] rating) {
            int n = rating.length;
            int ans = 0;
            // i 代表當前考慮的中心元素
            for (int i = 0; i < n; ++i) {
                int leftLess = 0, leftGreater = 0, rightLess = 0, rightGreater = 0;
                // 找出比 rating[i] 小的元素個數和比 rating[i] 大的元素個數
                for (int j = 0; j < i; ++j) {
                    if (rating[j] < rating[i])
                        ++leftLess;
                    else if (rating[j] > rating[i])
                        ++leftGreater;
                }
                // 找出比 rating[i] 小的元素個數和比 rating[i] 大的元素個數
                for (int j = i + 1; j < n; ++j) {
                    if (rating[j] < rating[i])
                        ++rightLess;
                    else if (rating[j] > rating[i])
                        ++rightGreater;
                }
                // 以 rating[i] 為中心，左邊比 rating[i] 小的元素個數乘上右邊比 rating[i] 大的元素個數   
                ans += leftLess * rightGreater + leftGreater * rightLess;
            }
            return ans;
        }
    }
}
