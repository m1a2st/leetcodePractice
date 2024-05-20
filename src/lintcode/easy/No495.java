package lintcode.easy;

import java.util.LinkedList;
import java.util.List;

public class No495 {

    public class Stack {

        List<Integer> stack = new LinkedList<>();
        int position = -1;

        /*
         * @param x: An integer
         * @return: nothing
         */
        public void push(int x) {
            // write your code here
            stack.add(x);
            ++position;
        }

        /*
         * @return: nothing
         */
        public void pop() {
            stack.remove(position);
            --position;
        }

        /*
         * @return: An integer
         */
        public int top() {
            // write your code here
            return stack.get(position);
        }

        /*
         * @return: True if the stack is empty
         */
        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }
}
