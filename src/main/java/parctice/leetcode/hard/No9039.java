package parctice.leetcode.hard;

import org.junit.jupiter.api.Test;

// TODO 太難了，根本想不到
public class No9039 {

    @Test
    public void test() {
        Solution solution = new Solution();
        String[] wordsContainer = {"abcd", "bcd", "xbcd"};
        String[] wordsQuery = {"cd", "bcd", "xyz"};
        int[] ans = solution.stringIndices(wordsContainer, wordsQuery);
        for (int an : ans) {
            System.out.println(an);
        }
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public int length = Integer.MAX_VALUE;
        public int index = -1;
    }

    class Solution {
        private final TrieNode root = new TrieNode();

        public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
            int[] ans = new int[wordsQuery.length];
            int minIndex = 0;

            for (int i = 0; i < wordsContainer.length; ++i) {
                insert(wordsContainer[i], i);
                if (wordsContainer[i].length() < wordsContainer[minIndex].length()) {
                    minIndex = i;
                }
            }

            for (int i = 0; i < wordsQuery.length; ++i) {
                final int index = search(wordsQuery[i]);
                ans[i] = index == -1 ? minIndex : index;
            }

            return ans;
        }


        private void insert(String word, int index) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; --i) {
                final int j = word.charAt(i) - 'a';
                if (node.children[j] == null) {
                    node.children[j] = new TrieNode();
                }
                node = node.children[j];
                if (node.length > word.length()) {
                    node.length = word.length();
                    node.index = index;
                }
            }
        }

        private int search(final String word) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; --i) {
                final int j = word.charAt(i) - 'a';
                if (node.children[j] == null)
                    return node.index;
                node = node.children[j];
            }
            return node.index;
        }
    }
}
