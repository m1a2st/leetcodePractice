package parctice.leetcode.medium;

public class No211 {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    class WordDictionary {

        private final TrieNode root = new TrieNode();

        public void addWord(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
            }
            current.isEnd = true;
        }

        public boolean search(String word) {
            return dfs(word, 0, root);
        }

        private boolean dfs(String word, int s, TrieNode node) {
            if (s == word.length()) {
                return node.isEnd;
                }
            if (word.charAt(s) != '.') {
                TrieNode next = node.children[word.charAt(s) - 'a'];
                return next != null && dfs(word, s + 1, next);
            }

            for (int i = 0; i < 26; ++i) {
                if (node.children[i] != null && dfs(word, s + 1, node.children[i])) {
                    return true;
                }
            }

            return false;
        }
    }

}
