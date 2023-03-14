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

    class MyStack {
        private final Queue<Integer> mainQ;
        private final Queue<Integer> auxQ;

        public MyStack() {
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

}
