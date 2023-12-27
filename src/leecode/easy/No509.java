package leecode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.IntStream;

public class No509 {

    static class Solution {

        public static void main(String[] args) {
            IntStream.range(0, 10).forEach(
                    s -> System.out.println(fib(s))
            );
        }

        static int[] res = new int[31];

        public static int fib(int n) {
            if (n <= 1) {
                return n;
            }
            if (res[n] != 0) {
                return res[n];
            }
            return res[n] = fib(n - 1) + fib(n - 2);
        }

        public static int fib2(int n) {
            if (n <= 1) return n;
            res[0] = 0;
            res[1] = 1;
            for (int i = 2; i < n; i++) {
                res[i] = res[i - 1] + res[i - 2];
            }
            return res[n];
        }
    }

    static class SolutionNew {

        static int[] res = new int[31];

        public int fib(int n) {
            if (n <= 1) {
                return 1;
            }
            res[0] = 0;
            res[1] = 1;
            for (int i = 2; i < n; i++) {
                res[i] = res[i - 1] + res[i - 2];
            }
            return res[n];
        }
    }
}
