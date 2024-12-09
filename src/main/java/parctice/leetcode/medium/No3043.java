package parctice.leetcode.medium;

public class No3043 {

    class TrieNode {
        TrieNode[] children = new TrieNode[10];
    }
    
    class Trie {
        TrieNode root = new TrieNode();
        
        public void insert(String s) {
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                int idx = c - '0';
                if (curr.children[idx] == null)
                    curr.children[idx] = new TrieNode();
                curr = curr.children[idx];
            }
        }
        
        public int depth(String s) {
            int depth = 0;
            TrieNode curr = root;
            for (char c : s.toCharArray()) {
                int idx = c - '0';
                if (curr.children[idx] == null)
                    break;
                curr = curr.children[idx];
                ++depth;
            }
            return depth;
        }
        
    }

    class Solution {
        public int longestCommonPrefix(int[] arr1, int[] arr2) {
            int ans = 0;
            Trie trie = new Trie();

            for (final int num : arr1)
                trie.insert(Integer.toString(num));

            for (final int num : arr2)
                ans = Math.max(ans, trie.depth(Integer.toString(num)));

            return ans;
        }
    }
}
