package leetcode.easy;

public class No1791 {

    class Solution {
        public int findCenter(int[][] edges) {
            int[] count = new int[edges.length + 2];
            for (int[] edge : edges) {
                count[edge[0]]++;
                count[edge[1]]++;
            }
            for (int i = 1; i < count.length; i++) {
                if (count[i] == edges.length) {
                    return i;
                }
            }
            return -1;
        }
    }

    class SolutionNew {
        public int findCenter(int[][] edges) {
            int a = edges[0][0];
            int b = edges[0][1];

            if(a == edges[1][0] || a == edges[1][1])
                return a;
            else
                return b;
        }
    }
}
