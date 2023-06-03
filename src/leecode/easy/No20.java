package leecode.easy;

import java.util.Stack;

/**
 * @Author m1a2st
 * @Date 2023/4/10
 * @Version v1.0
 */
public class No20 {

    class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if(c == '('){
                    stack.push(')');
                }else if(c == '{'){
                    stack.push('}');
                }else if (c == '['){
                    stack.push(']');
                }else if (stack.isEmpty() || stack.pop() != c){
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }
}
