package parctice.leetcode.medium;

public class No1472 {

    class BrowserHistory {
        String[] history = new String[101];
        int index = 0;
        int maxIndex = 0;

        public BrowserHistory(String homepage) {
            // index 0 == homepage
            history[index] = homepage;
        }

        public void visit(String url) {
            maxIndex = ++index;
            history[index] = url;
        }

        public String back(int steps) {
            index = Math.max(0, index - steps);
            return history[index];
        }

        public String forward(int steps) {
            index = Math.min(index + steps, maxIndex);
            return history[index];
        }
    }

}
