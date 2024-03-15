package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No78 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3};
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
            recursive(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }

    class Solution {
        List<List<Integer>> lists = new ArrayList<>();

        public List<List<Integer>> subsets(int[] nums) {
            List<Integer> track = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            recursive(nums, track, used);
            return lists;
        }

        private void recursive(int[] nums, List<Integer> track, boolean[] used) {
            if (track.size() == used.length) {
                lists.add(new ArrayList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if(used[i]){
                    continue;
                }
                track.add(nums[i]);
                used[i] = true;
                recursive(nums, track, used);
                track.remove(track.size() - 1);
                used[i] = false;
            }
        }
    }
}
