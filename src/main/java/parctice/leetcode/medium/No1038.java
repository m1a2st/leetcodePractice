package main.java.parctice.leetcode.medium;

import static kotlin.reflect.jvm.internal.impl.utils.DFS.dfs;

public class No1038 {


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
        public TreeNode bstToGst(TreeNode root) {
            dfs(root, 0);
            return root;
        }

        private void dfs(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            dfs(root.right, sum);
            sum += root.val;
            dfs(root.left, sum);
        }
    }
}
