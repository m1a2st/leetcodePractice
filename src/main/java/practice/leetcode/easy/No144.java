package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class No144 {


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

        List<Integer> ans = new ArrayList<>();

        public List<Integer> preorderTraversal(TreeNode root) {
            preorder(root);
            return ans;
        }

        private void preorder(TreeNode root) {
            if (root == null) {
                return;
            }
            ans.add(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }
}
