package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class No145 {


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

        public List<Integer> postorderTraversal(TreeNode root) {
            postorder(root);
            return ans;
        }

        private void postorder(TreeNode root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            ans.add(root.val);
            postorder(root.right);
        }
    }
}
