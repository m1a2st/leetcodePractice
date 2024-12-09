package main.java.parctice.leetcode.medium;

import java.util.Arrays;

public class No2601 {

    /**
     * 1. **初始化**：
     *     - `maxElement`：找出數組 `nums` 中的最大元素。
     *     - `sieve`：建立一個布爾數組，用來標記質數。初始時，所有元素都設為 `true`，除了 `sieve[1]` 設為 `false`。
     * <p>
     * 2. **埃拉托斯特尼篩法**：
     *     - 使用埃拉托斯特尼篩法來找出 `maxElement` 以內的所有質數。這個方法會將所有非質數標記為 `false`。
     * <p>
     * 3. **主邏輯**：
     *     - `currValue`：初始化為 1，表示當前目標值。
     *     - `i`：初始化為 0，表示數組的當前索引。
     *     - 使用 `while` 迴圈遍歷數組 `nums`：
     *         - 計算 `difference`，即 `nums[i]` 減去 `currValue`。
     *         - 如果 `difference` 小於 0，表示 `nums[i]` 已經小於 `currValue`，返回 `false`。
     *         - 如果 `difference` 是質數或等於 0，則將索引 `i` 加 1，表示可以將 `nums[i]` 減去一個質數使其等於 `currValue`。
     *         - 否則，增加 `currValue`，嘗試下一個目標值。
     */
    class Solution {

        public boolean primeSubOperation(int[] nums) {
            int maxElement = getMaxElement(nums);
            // Store the sieve array.
            boolean[] sieve = new boolean[maxElement + 1];
            Arrays.fill(sieve, true);
            sieve[1] = false;
            for (int i = 2; i <= Math.sqrt(maxElement + 1); i++) {
                if (sieve[i]) {
                    for (int j = i * i; j <= maxElement; j += i) {
                        sieve[j] = false;
                    }
                }
            }
            // Start by storing the currValue as 1, and the initial index as 0.
            int currValue = 1;
            int i = 0;
            while (i < nums.length) {
                // Store the difference needed to make nums[i] equal to currValue.
                int difference = nums[i] - currValue;
                // If difference is less than 0, then nums[i] is already less than
                // currValue. Return false in this case.
                if (difference < 0) {
                    return false;
                }
                // If the difference is prime or zero, then nums[i] can be made
                // equal to currValue.
                if (sieve[difference] || difference == 0) {
                    i++;
                } else {
                    // Otherwise, try for the next currValue.
                }
                currValue++;
            }
            return true;
        }

        private int getMaxElement(int[] nums) {
            int max = -1;
            for (int num : nums) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }

    }
}
