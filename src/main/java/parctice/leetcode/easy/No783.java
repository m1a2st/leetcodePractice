package main.java.parctice.leetcode.easy;

import main.java.parctice.leetcode.medium.ListNode;

public class No783 {


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

        private int ans = Integer.MAX_VALUE;
        private Integer pred = null;

        public int minDiffInBST(TreeNode root) {
            inorder(root);
            return ans;
        }

        private void inorder(TreeNode root) {
            if (root == null) {
                return;
            }

            inorder(root.left);
            if (pred != null) {
                ans = Math.min(ans, root.val - pred);
            }
            pred = root.val;
            inorder(root.right);
        }
    }

    class SolutionNew {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode p1 = dummy.next;
            ListNode p2 = dummy.next.next;
            while (p2 != null) {
                while (p2 != null && p1.val == p2.val) {
                    p2 = p2.next;
                }
                p1.next = p2;
                p1 = p1.next;
            }
            return dummy.next;
        }
    }
}
