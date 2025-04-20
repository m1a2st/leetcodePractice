package practice.leetcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class No114 {


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

        Queue<TreeNode> cache = new ArrayDeque<>();

        public void flatten(TreeNode root) {
            preOrder(root);
            cache.poll();
            while (!cache.isEmpty()) {
                TreeNode node = cache.poll();
                root.left = null;
                root.right = node;
                root = node;
            }
        }

        private void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            cache.add(root);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    class SolutionN {
        public void flatten(TreeNode root) {
            if (root == null)
                return;

            flatten(root.left);
            flatten(root.right);

            TreeNode left = root.left;   // flattened left
            TreeNode right = root.right; // flattened right

            root.left = null;
            root.right = left;

            // Connect the original right subtree to the end of the new right subtree.
            TreeNode rightmost = root;
            while (rightmost.right != null) {
                rightmost = rightmost.right;
            }
            rightmost.right = right;
        }
    }
}
