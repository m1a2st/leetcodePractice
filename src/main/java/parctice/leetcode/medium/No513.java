package main.java.parctice.leetcode.medium;

public class No513 {


    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {

        int ans = 0;
        int maxDepth = 0;

        public int findBottomLeftValue(TreeNode root) {
            traversal(root, 1);
            return ans;
        }

        private void traversal(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (depth > maxDepth) {
                maxDepth = depth;
                ans = root.val;
            }
            traversal(root.left, depth + 1);
            traversal(root.right, depth + 1);
        }
    }

    class SolutionNew {

        int ans = 0;
        int maxDepth = 0;

        public int findBottomLeftValue(TreeNode root) {
            traversal(root, 1);
            return ans;
        }

        private void traversal(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (depth > maxDepth) {
                maxDepth = depth;
                ans = root.val;
            }
            traversal(root.left, depth + 1);
            traversal(root.right, depth + 1);
        }
    }
}
