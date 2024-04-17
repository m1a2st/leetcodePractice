package leetcode.hard;

import java.util.*;

public class No127 {

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>(wordList);
            if (!set.contains(endWord)) {
                return 0;
            }
            int ans = 0;
            Deque<String> queue = new ArrayDeque<>(Arrays.asList(beginWord));
            while (!queue.isEmpty()) {
                ++ans;
                for (int size = queue.size(); size > 0; size--) {
                    StringBuilder sb = new StringBuilder(queue.poll());
                    for (int i = 0; i < sb.length(); i++) {
                        char cache = sb.charAt(i);
                        for (char c = 'a'; c <= 'z'; ++c) {
                            sb.setCharAt(i, c);
                            String word = sb.toString();
                            if (word.equals(endWord)) {
                                return ans + 1;
                            }
                            if (set.contains(word)) {
                                queue.offer(word);
                                set.remove(word);
                            }
                        }
                        sb.setCharAt(i, cache);
                    }
                }
            }

            return 0;
        }
    }

    class SolutionP {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>(wordList);
            if (!set.contains(endWord)) {
                return 0;
            }
            int ans = 0;
            ArrayDeque<String> queue = new ArrayDeque<>();
            queue.add(beginWord);
            while (!queue.isEmpty()) {
                ans++;
                for (int size = queue.size(); size > 0; size--) {
                    StringBuilder sb = new StringBuilder(queue.poll());
                    for (int i = 0; i < sb.length(); i++) {
                        char cache = sb.charAt(i);
                        for (char c = 'a'; c <= 'z'; c++) {
                            sb.setCharAt(i, c);
                            String word = sb.toString();
                            if (endWord.equals(word)) {
                                return ans + 1;
                            }
                            if (set.contains(word)) {
                                queue.offer(word);
                                set.remove(word);
                            }
                        }
                        sb.setCharAt(i, cache);
                    }
                }
            }
            return 0;
        }
    }
}
