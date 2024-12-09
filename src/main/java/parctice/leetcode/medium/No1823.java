package parctice.leetcode.medium;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;

public class No1823 {
    
    @Test
    public void test() {
        Solution s = new Solution();
        out.println(s.findTheWinner(5, 2));
    }

    class Solution {
        public int findTheWinner(int n, int k) {
            int ans = 0;
            for (int i = 2; i <= n; i++) {
                ans = (ans + k) % i;
            }
            return ans + 1;
        }
    }

    @Nested
    class Josephus {
        public static List<Integer> awayOrder(int len, int k) {
            List<Integer> numbers = new LinkedList<>();
            for(int i = 1; i <= len; i++) { 
                numbers.add(i); 
            }

            List<Integer> awayOrder = new ArrayList<>(len);
            for(int i = 2;;) {
                awayOrder.add(numbers.remove(i));
                if(numbers.isEmpty()) { break; }
                i = (i + k - 1) % numbers.size();
            }

            return awayOrder;
        }

        public static List<Integer> josephus(List<Integer> awayOrder) {
            List<Integer> josephus = new ArrayList<>(awayOrder.size());
            for(int i = 1; i <= awayOrder.size(); i++) {
                josephus.add(awayOrder.indexOf(i) + 1);
            }
            return josephus;
        }

        public static List<Integer> josephus(int len, int k) {
            return josephus(awayOrder(len, k));
        }

        @Test
        public void testJ() {
            List<Integer> awayOrder = awayOrder(41, 3);
            out.print("自殺順序：");
            for(Integer number : awayOrder) {
                out.printf("%3d", number);
            }
            out.print("\n約瑟夫環：");
            for(Integer number : josephus(awayOrder)) {
                out.printf("%3d", number);
            }
        }
    }

}
