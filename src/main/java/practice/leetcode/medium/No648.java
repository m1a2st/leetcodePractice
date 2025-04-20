package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

public class No648 {

    @Test
    void test() {
        Solution solution = new Solution();
        System.out.println(solution.replaceWords(List.of("a", "aa", "aaa", "aaaa"),
                "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa")); // the cat was rat by the bat
    }

    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;
    }

    class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            TrieNode trie = new TrieNode();
            for (String root : dictionary) {
                TrieNode cur = trie;
                for (char letter : root.toCharArray()) {
                    if (cur.children[letter - 'a'] == null) {
                        cur.children[letter - 'a'] = new TrieNode();
                    }
                    cur = cur.children[letter - 'a'];
                }
                cur.isWord = true;
            }

            StringBuilder ans = new StringBuilder();
            for (String word : sentence.split("\\s+")) {
                if (!ans.isEmpty()) {
                    ans.append(" ");
                }

                TrieNode cur = trie;
                StringBuilder subString = new StringBuilder();
                for (char letter : word.toCharArray()) {
                    if (cur.children[letter - 'a'] == null) {
                        break;
                    } else {
                        if (cur.isWord) {
                            break;
                        } else {
                            subString.append(letter);
                            cur = cur.children[letter - 'a'];
                        }
                    }
                }
                ans.append(cur.isWord ? subString : word);
            }
            return ans.toString();
        }
    }
}
