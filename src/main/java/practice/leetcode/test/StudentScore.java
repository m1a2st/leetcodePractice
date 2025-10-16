package practice.leetcode.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentScore {

    class Solution {
        public Map<Integer, List<Integer>> topThreeScores(int[][] scores) {
            Map<Integer, int[]> studentScores = new HashMap<>();
            for (int i = 0; i < scores.length; i++) {
                int studentId = scores[i][0];
                int score = scores[i][1];
                studentScores.putIfAbsent(studentId, new int[101]);
                studentScores.get(studentId)[score]++;
            }

            Map<Integer, List<Integer>> result = new HashMap<>();
            for (Map.Entry<Integer, int[]> entry : studentScores.entrySet()) {
                int studentId = entry.getKey();
                int[] scoreCounts = entry.getValue();
                List<Integer> topScores = new java.util.ArrayList<>();
                for (int score = 100; score >= 0 && topScores.size() < 3; score--) {
                    while (scoreCounts[score] > 0 && topScores.size() < 3) {
                        topScores.add(score);
                        scoreCounts[score]--;
                    }
                }
                result.put(studentId, topScores);
            }
            return result;
        }
    }

    class SortByLength {
        public String[] sortByLength(String[] s1, String[] s2) {
            String[] combined = new String[s1.length + s2.length];
            System.arraycopy(s1, 0, combined, 0, s1.length);
            System.arraycopy(s2, 0, combined, s1.length, s2.length);

            mergeSort(combined);
            return combined;
        }

        public void mergeSort(String[] arr) {
            int len = arr.length;
            if (len > 1) {
                int mid = len / 2;
                String[] left = new String[mid];
                System.arraycopy(arr, 0, left, 0, mid);
                mergeSort(left);
                String[] right = new String[len - mid];
                System.arraycopy(arr, mid, right, 0, len - mid);
                mergeSort(right);
                merge(left, right, arr);
            }
        }

        private void merge(String[] left, String[] right, String[] arr) {
            int i = 0, j = 0, k = 0;
            while (i < left.length && j < right.length) {
                if (left[i].length() <= right[j].length()) {
                    arr[k++] = left[i++];
                } else {
                    arr[k++] = right[j++];
                }
            }
            while (i < left.length) {
                arr[k++] = left[i++];
            }
            while (j < right.length) {
                arr[k++] = right[j++];
            }
        }
    }
}
