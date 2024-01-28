package leecode.hard;

import java.util.HashMap;
import java.util.Map;

public class No1074 {

    class Solution {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            final int n = matrix[0].length;
            int ans = 0;

            // Transfer each row in the matrix to the prefix sum.
            for (int[] row : matrix)
                for (int i = 1; i < n; ++i)
                    row[i] += row[i - 1];

            for (int baseCol = 0; baseCol < n; ++baseCol)
                for (int j = baseCol; j < n; ++j) {
                    Map<Integer, Integer> prefixCount = new HashMap<>();
                    prefixCount.put(0, 1);
                    int sum = 0;
                    for (int[] ints : matrix) {
                        if (baseCol > 0)
                            sum -= ints[baseCol - 1];
                        sum += ints[j];
                        ans += prefixCount.getOrDefault(sum - target, 0);
                        prefixCount.merge(sum, 1, Integer::sum);
                    }
                }

            return ans;
        }
    }

    class SolutionNew {
        public int numSubmatrixSumTarget(int[][] matrix, int target) {
            if (matrix.length == 0) {
                return 0;
            }

            int col = matrix[0].length;
            int count = 0;
            /*
              將每一列的數字轉換成前綴和
              例如:
              1 2 3
              4 5 6
              7 8 9
              轉換後:
              1 3 6
              4 9 15
              7 15 24
              作用: 這樣可以快速算出任意一個矩陣的和
             */
            for (int[] ints : matrix) {
                for (int j = 1; j < col; j++) {
                    ints[j] += ints[j - 1];
                }
            }
            /*
              這裡的思路是:
              1. 先固定一個起始列
              2. 然後從起始列開始往後遍歷
              3. 每次遍歷都會得到一個矩陣
              4. 然後將矩陣的每一列的數字相加
              5. 將相加後的數字放入map中
              6. 然後判斷map中是否存在sum - target的key
              7. 如果存在, 則將count加上map.get(sum - target)
              8. 最後將sum放入map中
              9. 重複2-8步驟
              10. 最後返回count
             */
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int startCol = 0; startCol < col; startCol++) {
                for (int currCol = startCol; currCol < col; currCol++) {
                    map.clear();
                    map.put(0, 1);
                    int sum = 0;
                    for (int[] ints : matrix) {
                        sum += ints[currCol] - (startCol > 0 ? ints[startCol - 1] : 0);
                        if (map.containsKey(sum - target)) {
                            count += map.get(sum - target);
                        }
                        map.put(sum, map.getOrDefault(sum, 0) + 1);
                    }
                }
            }
            return count;
        }
    }
}
