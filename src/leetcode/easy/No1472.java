package leetcode.easy;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author
 * @Date
 * @Version
 * @Description
 */
public class No1472 {

    static class BrowserHistory {

        private final Stack<String> s1 = new Stack<>();
        private final Stack<String> s2 = new Stack<>();

        public BrowserHistory(String homepage) {
            s1.push(homepage);
        }

        public void visit(String url) {
            s1.push(url);
            s2.clear();
        }

        public String back(int steps) {
            if (steps > s1.size() - 1) return null;
            for (int i = 0; i < steps; i++) {
                s2.push(s1.pop());
            }
            return s1.peek();
        }

        public String forward(int steps) {
            if (steps > s2.size()) return null;
            for (int i = 0; i < steps; i++) {
                s1.push(s2.pop());
            }
            return s1.peek();
        }
    }

    static class BrowserHistoryArrayList {

        private final ArrayList<String> history = new ArrayList<>();
        int currentIndex = 0;
        int lastValidIndex = 0;

        public BrowserHistoryArrayList(String homepage) {
            history.add(homepage);
        }

        public void visit(String url) {
            if (currentIndex == history.size() - 1) {
                history.add(url);
            } else {
                history.set(currentIndex + 1, url);
            }
            currentIndex++;
            lastValidIndex = currentIndex;
        }

        public String back(int steps) {
            int targetIndex = Math.max(0, currentIndex - steps);
            currentIndex = targetIndex;
            return history.get(targetIndex);
        }

        public String forward(int steps) {
            int targetIndex = Math.max(lastValidIndex, currentIndex + steps);
            currentIndex = targetIndex;
            return history.get(targetIndex);
        }
    }
}
