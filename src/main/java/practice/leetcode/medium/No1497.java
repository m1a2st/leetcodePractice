package practice.leetcode.medium;

public class No1497 {

    /**
     *
     * 1. **計算餘數並更新計數數組**：
     *     ```java
     *     for (int num : arr) {
     *         count[(num % k + k) % k]++;
     *     }
     *     ```
     *     這段代碼遍歷數組 `arr` 中的每個數字 `num`，計算 `num` 除以 `k` 的餘數，並更新 `count` 
     *     數組中相應位置的計數。這裡使用 `(num % k + k) % k` 來確保餘數是非負的。
     *
     * 2. **檢查餘數配對**：
     *     ```java
     *     for (int i = 1; i <= k / 2; i++) {
     *         if (count[i] != count[k - i]) {
     *             return false;
     *         }
     *     }
     *     ```
     *     這段代碼檢查每個餘數 `i` 和 `k - i` 的計數是否相等。如果不相等，則返回 `false`，
     *     因為這意味著無法找到配對的數字使其和能被 `k` 整除。
     *
     * 3. **檢查餘數為零的數字**：
     *     ```java
     *     return count[0] % 2 == 0;
     *     ```
     *     最後，檢查餘數為零的數字的個數是否為偶數。如果是偶數，則返回 `true`，否則返回 `false`。
     *     這是因為餘數為零的數字必須成對出現才能使其和能被 `k` 整除。
     *
     */
    class Solution {
        public boolean canArrange(int[] arr, int k) {
            int[] count = new int[k];
            for (int num : arr) {
                count[(num % k + k) % k]++;
            }
            for (int i = 1; i <= k / 2; i++) {
                if (count[i] != count[k - i]) {
                    return false;
                }
            }
            return count[0] % 2 == 0;
        }
    }
}
