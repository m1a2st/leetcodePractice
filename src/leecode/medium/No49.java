package leecode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


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

    static class Solution {
        public static List<List<String>> groupAnagrams(String[] strs) {
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

    }
}
