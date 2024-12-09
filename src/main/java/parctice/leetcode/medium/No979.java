package main.java.parctice.leetcode.medium;

public class No979 {


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

        public int distributeCoins(TreeNode root) {
            traversal(root);
            return ans;
        }

        private void traversal(TreeNode root) {
            if (root == null) {
                return;
            }
            traversal(root.left);
            traversal(root.right);
            if (root.left != null) {
                ans += Math.abs(root.left.val - 1);
                root.val += root.left.val - 1;
            }
            if (root.right != null) {
                ans += Math.abs(root.right.val - 1);
                root.val += root.right.val - 1;
            }
        }
    }
}
