package main.java.parctice.leetcode.medium;

import main.java.parctice.leetcode.easy.No108;

import java.util.ArrayList;
import java.util.List;

public class No1382 {


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

        List<Integer> nums = new ArrayList<>();
        
        public TreeNode balanceBST(TreeNode root) {
            inorder(root);
            return build(0, nums.size() - 1);
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            nums.add(root.val);
            inorder(root.right);
        }

        /**
         * see {@link No108}
         */
        private TreeNode build(int left, int right) {
            if (left > right) {
                return null;
            }
            int mid = left + (right - left) / 2;
            return new TreeNode(nums.get(mid), build(left, mid - 1), build(mid + 1, right));
        }
    }
}
