package parctice.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No599 {

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] restaurant = findRestaurant(list1, list2);
        System.out.println(Arrays.toString(restaurant));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {
        if (list1.length > list2.length) {
            return findRestaurant(list2, list1);
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; ++i) {
            map.put(list1[i], i);
        }
        List<String> result = new ArrayList<>();
        int sum = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length && i <= sum; ++i) {
            String string = list2[i];
            if (!map.containsKey(string)) {
                continue;
            }
            int newSum = i + map.get(string);
            if (newSum <= sum) {
                if (newSum < sum) {
                    result.clear();
                }
                result.add(string);
                sum = newSum;
            }
        }
        return result.toArray(new String[0]);
    }
}
//    public String[] findRestaurant(String[] list1, String[] list2) {
//        int minIndex = Integer.MAX_VALUE;
//        ArrayList<String> strings = new ArrayList<>();
//        for (int i = 0; i < list1.length; i++) {
//            for (int j = 0; j < list2.length; j++) {
//                if (list1[i].equals(list2[j])) {
//                    int sum = i + j;
//                    if (sum < minIndex) {
//                        strings.clear();
//                        strings.add(list1[i]);
//                        minIndex = sum;
//                    } else if (sum == minIndex) {
//                        strings.add(list1[i]);
//                    }
//                }
//            }
//        }
//        return (String[])strings.toArray(new String[0]);
//    }

