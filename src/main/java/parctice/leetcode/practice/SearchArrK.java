package main.java.parctice.leetcode.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class SearchArrK {
    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, i + 2);
        }
        for (int i : arr) {
            if (map.containsValue(i)) {
                System.out.println((i - 2) + " " + map.get(i - 2));
            }
        }
    }
}
