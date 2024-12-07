package leetcode.medium;

public class No1760 {
    /**
     *
     * l：最小可能的罰值，初始化為 1，因為最少有 1 個球。
     * r：最大可能的罰值，初始化為 nums 中的最大值。
     * <p>
     * 二分搜尋：
     * 計算中間值 m = (l + r) / 2 作為當前假設的罰值。
     * 調用 numOperations(nums, m) 計算將所有袋子中的球數減少至不超過 m 所需的操作次數：
     * 如果操作次數不超過 maxOperations，說明 m 是可能的罰值，嘗試縮小範圍（r = m）。
     * 否則，表示 m 過小，增加範圍（l = m + 1）。
     * <p>
     * 結束條件：
     * 當 l == r 時，找到最小的罰值，直接返回。
     * <p>
     * 方法 numOperations
     * 計算對每個袋子球數 num，當限制為 m 時需要的操作次數：
     * 使用公式 (num - 1) / m，這是因為當袋子內球數為 num 時，將其分成不超過 m 的袋子所需的操作次數可以通過整數除法計算。
     * 累計所有袋子的操作次數。
     * 返回總操作次數。
     */
    class Solution {
        public int minimumSize(int[] nums, int maxOperations) {
            int l = 1;
            int r = 0;
            for (final int num : nums)
                r = Math.max(r, num);

            while (l < r) {
                final int m = (l + r) / 2;
                if (numOperations(nums, m) <= maxOperations)
                    r = m;
                else
                    l = m + 1;
            }

            return l;
        }

        // Returns the number of operations required to make m penalty.
        private int numOperations(int[] nums, int m) {
            int operations = 0;
            for (final int num : nums)
                operations += (num - 1) / m;
            return operations;
        }
    }
}
