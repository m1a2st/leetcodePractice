package parctice.leetcode.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No2215 {

    class Solution {
        public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
            Set<Integer> s1 = new HashSet<>();
            Set<Integer> s1p = new HashSet<>();
            Set<Integer> s2 = new HashSet<>();
            List<List<Integer>> res = new ArrayList<>();
            for (int i : nums1) {
                s1.add(i);
                s1p.add(i);
            }
            for (int i : nums2) {
                s2.add(i);
            }
            s1.removeAll(s2);
            s2.removeAll(s1p);
            res.add(new ArrayList<>(s1));
            res.add(new ArrayList<>(s2));
            return res;
        }
    }

    @Test
    public void test() {
        Set<Integer> s1 = new HashSet<>() {{
            add(1);
            add(2);
            add(3);
        }};
        Set<Integer> s2 = new HashSet<>() {{
            add(3);
            add(4);
            add(5);
        }};

        s1.retainAll(s2);
        s1.forEach(System.out::println);
    }
}
