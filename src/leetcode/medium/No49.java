package leetcode.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No49 {

    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for (String word : strs) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String sortedWord = String.valueOf(chars);

                map.computeIfAbsent(sortedWord, v -> new ArrayList<>()).add(word);
            }
            return new ArrayList<>(map.values());
        }
    }

    class SolutionNew {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<Key, List<String>> map = new HashMap<>();

            for (String word : strs) {
                Key key = new Key(word);

                map.computeIfAbsent(key, v -> new ArrayList<>()).add(word);
            }
            return new ArrayList<>(map.values());
        }

        class Key {
            int[] count = new int[26];

            public Key(String word) {
                for (char c : word.toCharArray()) {
                    count[c - 'a']++;
                }
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                Key key = (Key) o;

                return Arrays.equals(count, key.count);
            }

            @Override
            public int hashCode() {
                return Arrays.hashCode(count);
            }
        }
    }


    @Test
    public void test() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new Solution().groupAnagrams(strs);
        assertEquals(3, lists.size());
    }

}
