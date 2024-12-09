package parctice.leetcode.hard;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class No895 {

    class FreqStackBest {
        public void push(int val) {
            count.merge(val, 1, Integer::sum);
            countToStack.putIfAbsent(count.get(val), new ArrayDeque<>());
            countToStack.get(count.get(val)).push(val);
            maxFreq = Math.max(maxFreq, count.get(val));
        }

        public int pop() {
            final int val = countToStack.get(maxFreq).pop();
            count.merge(val, -1, Integer::sum);
            if (countToStack.get(maxFreq).isEmpty())
                --maxFreq;
            return val;
        }

        private int maxFreq = 0;
        private final Map<Integer, Integer> count = new HashMap<>();
        private final Map<Integer, Deque<Integer>> countToStack = new HashMap<>();
    }

    class FreqStack {

        Map<Integer, Integer> map = new HashMap<>();
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        Stack<Pair> temp = new Stack<>();

        public void push(int val) {
            int freq = map.merge(val, 1, Integer::sum);
            while (!stack.isEmpty() && stack.peek().frequent > freq) {
                temp.push(stack.pop());
            }
            stack.push(new Pair(val, freq));
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        public int pop() {
            int num = stack.pop().num;
            map.put(num, map.get(num) - 1);
            return num;
        }
    }

    class Pair {
        int num;
        int frequent;

        public Pair(int num, int frequent) {
            this.num = num;
            this.frequent = frequent;
        }
    }

}
