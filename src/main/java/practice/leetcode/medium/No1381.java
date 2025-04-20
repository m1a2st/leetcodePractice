package practice.leetcode.medium;

public class No1381 {

    class CustomStack {
        int[] stack;
        int top;

        public CustomStack(int maxSize) {
            stack = new int[maxSize];
            top = -1;
        }

        public void push(int x) {
            if (top < stack.length - 1) {
                stack[++top] = x;
            }
        }

        public int pop() {
            return top > -1 ? stack[top--] : -1;
        }

        public void increment(int k, int val) {
            k = Math.min(k, top + 1);
            for (int i = 0; i < k; i++) {
                stack[i] += val;
            }
        }
    }

}
