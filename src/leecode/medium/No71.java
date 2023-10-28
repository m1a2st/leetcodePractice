package leecode.medium;

import org.junit.Test;

import java.util.Stack;
import java.util.stream.Collectors;

public class No71 {

    @Test
    public void test() {
        String s = "/home//foo/";
        Solution s1 = new Solution();
        System.out.println(s1.simplifyPath(s));
    }

    class Solution {
        public String simplifyPath(String path) {
            String[] dir = path.split("/");
            Stack<String> stack = new Stack<>();
            for (String s : dir) {
                if (".".equals(s) || s.isEmpty()) {
                    continue;
                } else if ("..".equals(s)) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else {
                    stack.push(s);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (String s : stack) {
                sb.append("/");
                sb.append(s);
            }
            return stack.isEmpty() ? "/" : sb.toString();
        }
    }
}
