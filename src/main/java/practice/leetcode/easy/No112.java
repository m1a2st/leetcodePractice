package practice.leetcode.easy;

public class No112 {


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
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) {
                return false;
            }
            if (root.val == targetSum && root.left == null && root.right == null) {
                return true;
            }
            int diff = targetSum - root.val;
            return hasPathSum(root.right, diff) ||
                    hasPathSum(root.left, diff);
        }
    }
}
