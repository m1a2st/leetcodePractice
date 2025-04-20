package practice.leetcode.medium;


import org.junit.jupiter.api.Test;

import java.util.Stack;

public class No901 {

    @Test
    public void test01() {
        StockSpanner stockSpanner = new StockSpanner();
        int[] arr = {100, 80, 60, 70, 60, 75, 85};
        for (int i : arr) {
            System.out.println(stockSpanner.next(i));
        }
    }

    class StockSpanner {

        private final Stack<Pair> stack = new Stack<>();

        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && stack.peek().key <= price)
                span += stack.pop().value;
            stack.push(new Pair(price, span));
            return span;
        }
    }

    class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
