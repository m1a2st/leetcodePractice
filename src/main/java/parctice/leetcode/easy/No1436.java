package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class No1436 {

    @Test
    public void test() {
        Solution solution = new Solution();
        List<List<String>> paths = List.of(
                List.of("London", "New York"),
                List.of("New York", "Lima"),
                List.of("Lima", "Sao Paulo"));
        String destCity = solution.destCity(paths);
        System.out.println(destCity);

    }


    class Solution {
        public String destCity(List<List<String>> paths) {
            if (paths.size() == 1)
                return paths.get(0).get(1);

            HashMap<String, String> map = new HashMap<>();
            for (List<String> path : paths) {
                map.put(path.get(0), path.get(1));
            }

            String origin = paths.get(0).get(0);
            while (map.containsKey(origin)) {
                origin = map.get(origin);
            }

            return origin;
        }
    }
}
