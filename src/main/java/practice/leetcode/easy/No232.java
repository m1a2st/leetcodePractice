package practice.leetcode.easy;

import java.util.Stack;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No232 {

    class MyQueue {
        private final Stack<Integer> main;
        private final Stack<Integer> aux;

        public MyQueue() {
            main = new Stack<>();
            aux = new Stack<>();
        }

        public void push(int x) {
            while (!main.empty()) aux.push(main.pop());
            main.push(x);
            while (!aux.isEmpty()) main.push(aux.pop());
        }

        public int pop() {
            return main.pop();
        }

        public int peek() {
            return main.peek();
        }

        public boolean empty() {
            return main.isEmpty();
        }
    }

    class MyQueue1 {

        private final Stack<Integer> main = new Stack<>();
        private final Stack<Integer> cache = new Stack<>();

        public void push(int x) {
            while (!main.empty()) cache.push(main.pop());
            main.push(x);
            while (!cache.empty()) main.push(cache.pop());
        }

        public int pop() {
            return main.pop();
        }

        public int peek() {
            return main.peek();
        }

        public boolean empty() {
            return main.isEmpty();
        }
    }
}
