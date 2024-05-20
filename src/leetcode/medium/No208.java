package leetcode.medium;

/**
 * @Author m1a2st
 * @Date 2023/7/18
 * @Version v1.0
 */
public class No208 {

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    class Trie {
        public void insert(String word) {
            TrieNode node = root;
            for (final char c : word.toCharArray()) {
                final int i = c - 'a';
                if (node.children[i] == null)
                    node.children[i] = new TrieNode();
                node = node.children[i];
            }
            node.isWord = true;
        }

        public boolean search(String word) {
            TrieNode node = find(word);
            return node != null && node.isWord;
        }

        public boolean startsWith(String prefix) {
            return find(prefix) != null;
        }

        private final TrieNode root = new TrieNode();

        private TrieNode find(String prefix) {
            TrieNode node = root;
            for (final char c : prefix.toCharArray()) {
                final int i = c - 'a';
                if (node.children[i] == null)
                    return null;
                node = node.children[i];
            }
            return node;
        }
    }
}
