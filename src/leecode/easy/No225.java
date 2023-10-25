package leecode.easy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No225 {

    class MyStackOld {
        private final Queue<Integer> mainQ;
        private final Queue<Integer> auxQ;

        public MyStackOld() {
            mainQ = new ArrayDeque<>();
            auxQ = new ArrayDeque<>();
        }

        public void push(int x) {
            while (!mainQ.isEmpty()) {
                auxQ.offer(mainQ.poll());
            }
            mainQ.offer(x);
            while (!auxQ.isEmpty()) {
                mainQ.offer(auxQ.poll());
            }
        }

        public int pop() {
            return mainQ.poll();
        }

        public int top() {
            return mainQ.peek();
        }

        public boolean empty() {
            return mainQ.isEmpty();
        }
    }

    class MyStack {

        private final Queue<Integer> main;
        private final Queue<Integer> cache;

        public MyStack() {
            main = new ArrayDeque<>();
            cache = new ArrayDeque<>();
        }

        public void push(int x) {
            while (!main.isEmpty()) {
                cache.offer(main.poll());
            }
            cache.offer(x);
            while (!cache.isEmpty()) {
                main.offer(cache.poll());
            }
        }

        public int pop() {
            return main.poll();
        }

        public int top() {
            return main.peek();
        }

        public boolean empty() {
            return main.isEmpty();
        }
    }
}
