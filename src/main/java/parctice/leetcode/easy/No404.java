package main.java.parctice.leetcode.easy;

public class No404 {

    class Solution {

        public int sumOfLeftLeaves(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return traversal(root, Symbol.RIGHT);
        }

        private int traversal(TreeNode root, Symbol symbol) {
            if (root == null) {
                return 0;
            }
            int sum = 0;
            if (root.left == null && root.right == null && symbol.equals(Symbol.LEFT)) {
                sum += root.val;
            }
            sum += traversal(root.left, Symbol.LEFT);
            sum += traversal(root.right, Symbol.RIGHT);
            return sum;
        }

        enum Symbol {
            RIGHT,
            LEFT
        }
    }
}
