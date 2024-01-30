package leecode.medium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No49 {

    public static void main(String[] args) {
        Solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).forEach(
                s -> s.forEach(System.out::println)
        );

    }

    class SolutionNew {
        public List<List<String>> groupAnagramsMap(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();

            for (String word : strs) {
                char[] chars = word.toCharArray();
                Arrays.sort(chars);
                String sortedWord = String.valueOf(chars);

                map.putIfAbsent(sortedWord, new ArrayList<>());
                map.get(sortedWord).add(word);
            }
            return new ArrayList<>(map.values());
        }
    }

    static class Solution {
        public static List<List<String>> groupAnagramsOld(String[] strs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                char[] chars = str.toCharArray();
                Arrays.sort(chars);
                String s = String.valueOf(chars);
                if (map.containsKey(s)) {
                    map.get(s).add(str);
                } else {
                    map.put(s, new ArrayList<>() {{
                        add(str);
                    }});
                }
            }
            return new ArrayList<>(map.values());
        }

        public static List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            for (String str : strs) {
                String str1 = sort(str);
                if (map.containsKey(str1)) {
                    List<String> ls = map.get(str1);
                    ls.add(str);
                } else {
                    map.put(str1, new ArrayList<>() {{
                        add(str);
                    }});
                }
            }
            return new ArrayList<>(map.values());
        }

        private static String sort(String str) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            return String.valueOf(charArray);
        }
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = solution.groupAnagrams(strs);
        assertEquals(3, lists.size());
    }
}
