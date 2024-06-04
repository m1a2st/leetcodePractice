package leetcode.medium;


import org.junit.jupiter.api.Test;

public class No208 {

    @Test
    void test() {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // true
        System.out.println(trie.search("app")); // false
        System.out.println(trie.startsWith("app")); // true
        trie.insert("app");
        System.out.println(trie.search("app")); // true
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    class Trie {

        private final TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
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

        private TrieNode find(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    return null;
                }
                node = node.children[c - 'a'];
            }
            return node;
        }
    }
}
