package leecode.medium;

import java.util.ArrayList;
import java.util.List;

public class No78 {

    public static void main(String[] args) {
        int[] a = {1,2,3};
        subsets(a).forEach(System.out::println);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        result.add(new ArrayList<>());
        recursive(nums, result, list, 0);
        return result;
    }

    private static void recursive(int[] nums, List<List<Integer>> result, List<Integer> list, int start) {
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            result.add(new ArrayList<>(list));
            recursive(nums,result,list,i+1);
            list.remove(list.size() -1);
        }
    }
}
