package practice.leetcode.medium;


public class No1014 {

    class Solution {
        public int maxScoreSightseeingPair(int[] values) {
            int maxScore = 0;             // 初始化最大分數為 0
            int maxI = values[0];         // 初始化第一個觀光點的 "values[i] + i"

            for (int j = 1; j < values.length; j++) {  // 從第二個觀光點開始遍歷
                maxScore = Math.max(maxScore, maxI + values[j] - j);
                // 更新最大分數，計算公式為 maxI + values[j] - j

                maxI = Math.max(maxI, values[j] + j);
                // 更新最大值 maxI，以確保它始終是最大 "values[i] + i"
            }

            return maxScore;  // 返回計算出的最大分數
        }
    }
}
