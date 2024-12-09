package main.java.parctice.leetcode.hard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * TODO fail
 */
public class No2092 {

    @Test
    public void test() {
        Solution solution = new Solution();
        int n = 5;
        int[][] meetings = new int[][]{{3, 4, 2}, {1, 2, 1}, {2, 3, 1}};
        int firstPerson = 1;
        List<Integer> allPeople = solution.findAllPeople(n, meetings, firstPerson);
        System.out.println(allPeople);
    }

    class Solution {

        Set<Integer> ans = new HashSet<>();

        public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
            Arrays.sort(meetings, Comparator.comparingInt(a -> a[2]));
            Map<Integer, List<int[]>> groupingMeetings =
                    Arrays.stream(meetings).collect(Collectors.groupingBy(a -> a[2], Collectors.toList()));
            ans.add(0);
            ans.add(firstPerson);
            for (Map.Entry<Integer, List<int[]>> entry : groupingMeetings.entrySet()) {
                List<int[]> value = entry.getValue();
                Set<Integer> numbers = new HashSet<>();
                for (int[] meeting : value) {
                    if (ans.contains(meeting[0]) || ans.contains(meeting[1])) {
                        numbers.add(meeting[0]);
                        numbers.add(meeting[1]);
                    }
                }
                int size;
                do {
                    size = numbers.size();
                    for (int[] meeting : value) {
                        if (numbers.contains(meeting[0]) || numbers.contains(meeting[1])) {
                            numbers.add(meeting[0]);
                            numbers.add(meeting[1]);
                        }
                    }
                } while (size != numbers.size());
                if (numbers.stream().anyMatch(ans::contains)) {
                    ans.addAll(numbers);
                }
            }
            return new ArrayList<>(ans);
        }
    }
}
