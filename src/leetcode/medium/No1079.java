package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class No1079 {

    @Test
    public void test() {
        System.out.println(new Solution().numTilePossibilities("AAB"));
    }

    class Solution {

        Set<String> ans = new HashSet<>();
        boolean[] visited;

        public int numTilePossibilities(String tiles) {
            char[] arr = tiles.toCharArray();
            visited = new boolean[arr.length];
            backtracking(arr, visited, "");
            return ans.size() - 1;
        }

        private void backtracking(char[] arr, boolean[] visited, String sub) {
            ans.add(sub);
            for (int i = 0; i < arr.length; i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                sub = sub + arr[i];
                backtracking(arr, visited, sub);
                sub = sub.substring(0, sub.length() - 1);
                visited[i] = false;
            }
        }
    }

    class SolutionFast {
        public int numTilePossibilities(String tiles) {
            int[] count = new int[26];
            for (char t : tiles.toCharArray())
                ++count[t - 'A'];
            return dfs(count);
        }

        private int dfs(int[] count) {
            int possibleSequences = 0;
            for (int i = 0; i < 26; ++i) {
                if (count[i] == 0)
                    continue;
                --count[i];
                possibleSequences += 1 + dfs(count);
                ++count[i];
            }
            return possibleSequences;
        }
    }
}
