package leetcode.contest;

import org.junit.Test;

import java.util.*;

public class No393 {

    @Test
    public void test() {
        new Solution100256().findLatestTime("?1:?6");
    }

    class Solution100256 {
        public String findLatestTime(String s) {
            StringBuilder sb = new StringBuilder();
            char[] arr = s.toCharArray();
            if (arr[0] == '?' && (arr[1] == '1' || arr[1] == '0')) {
                sb.append('1');
                sb.append(arr[1]);
            } else if (arr[0] == '?' && arr[1] == '?') {
                sb.append(11);
            } else if (arr[0] == '?') {
                sb.append(0);
                sb.append(arr[1]);
            } else if (arr[0] == '1' && arr[1] == '?') {
                sb.append('1');
                sb.append('1');
            } else if (arr[1] == '?') {
                sb.append('0');
                sb.append('9');
            } else {
                sb.append(arr[0]);
                sb.append(arr[1]);
            }
            sb.append(arr[2]);
            if (arr[3] == '?') {
                sb.append(5);
            } else {
                sb.append(arr[3]);
            }
            if (arr[4] == '?') {
                sb.append(9);
            } else {
                sb.append(arr[4]);
            }

            return sb.toString();
        }
    }

    @Test
    public void test2() {
        new Solution100265().maximumPrimeDifference(new int[]{4, 2, 9, 5, 3});
    }

    class Solution100265 {
        public int maximumPrimeDifference(int[] nums) {
            HashSet<Integer> cache = new HashSet<>(List.of(2, 3, 5, 7, 11, 13, 17, 19,
                    23, 29, 31, 37, 41, 43, 47, 53, 59, 61,
                    67, 71, 73, 79, 83, 89, 97));
            int max = 0;
            int min = nums.length;
            for (int i = 0; i < nums.length; i++) {
                if (cache.contains(nums[i])) {
                    max = Math.max(max, i);
                    min = Math.min(min, i);
                }
            }
            return max - min;
        }
    }

    @Test
    public void test3() {
        System.out.println(new Solution100267().findKthSmallest(new int[]{3, 6, 9}, 3));

    }

    class Solution100267 {
        public long findKthSmallest(int[] coins, int k) {
            TreeMap<Long, Integer> map = new TreeMap<>();

            for (int coin : coins) {
                for (long amount = coin; amount <= (long) k * coin; amount += coin) {
                    map.put(amount, 0);
                }
            }
            Set<Long> integers = map.keySet();
            int counter = 0;
            long ans = 0;
            for (Long integer : integers) {
                counter++;
                if (counter == k) {
                    ans = integer;
                    break;
                }
            }

            return ans;
        }

    }
}
