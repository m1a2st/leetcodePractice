package leecode.medium;

import java.util.Stack;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No150 {

    class Solution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> stack = new Stack<>();
            for (String token : tokens) {
                if("+".equals(token)){
                    stack.push(stack.pop() + stack.pop());
                }else if("-".equals(token)){
                    stack.push(- stack.pop() + stack.pop());
                }else if("*".equals(token)){
                    stack.push(stack.pop() * stack.pop());
                }else if("/".equals(token)){
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push( a / b);
                }else {
                    stack.push(Integer.valueOf(token));
                }
            }
            return stack.peek();
        }
    }
}
