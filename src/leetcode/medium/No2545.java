package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class No2545 {

    @Test
    public void test() {
        Solution solution = new Solution();
        solution.sortTheStudents(new int[][]{{10, 6, 9, 1}, {7, 5, 11, 2}, {4, 8, 3, 15}}, 2);
    }

    class Solution {
        public int[][] sortTheStudents(int[][] score, int k) {
            Pair[] temp = new Pair[score.length];
            for (int i = 0; i < score.length; i++) {
                temp[i] = new Pair(i, score[i][k]);
            }
            mergeSort(temp);
            int[][] res = new int[score.length][score[0].length];
            for (int i = 0; i < temp.length; i++) {
                res[i] = score[temp[i].index];
            }
            return res;
        }

        private void mergeSort(Pair[] arr) {
            int len = arr.length;
            if (len > 1) {
                Pair[] left = new Pair[len / 2];
                System.arraycopy(arr, 0, left, 0, len / 2);
                mergeSort(left);
                Pair[] right = new Pair[len - len / 2];
                System.arraycopy(arr, len / 2, right, 0, len - len / 2);
                mergeSort(right);
                merge(left, right, arr);
            }
        }

        private void merge(Pair[] left, Pair[] right, Pair[] temp) {
            int i = 0;
            int j = 0;
            int k = 0;
            while (i < left.length && j < right.length) {
                if (left[i].score < right[j].score) {
                    temp[k++] = right[j++];
                } else {
                    temp[k++] = left[i++];
                }
            }
            while (i < left.length) {
                temp[k++] = left[i++];
            }
            while (j < right.length) {
                temp[k++] = right[j++];
            }
        }
        class Pair {
            int index;
            int score;

            public Pair(int index, int score) {
                this.index = index;
                this.score = score;
            }
        }
    }
}
