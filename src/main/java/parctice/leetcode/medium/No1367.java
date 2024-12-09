package parctice.leetcode.medium;

public class No1367 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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
        public boolean isSubPath(ListNode head, TreeNode root) {
            if (head == null) {
                return true;
            }
            if (root == null) {
                return false;
            }
            return isSubPath(head, root.left) || isSubPath(head, root.right) || isSubPath(root, head);
        }

        private boolean isSubPath(TreeNode root, ListNode head1) {
            if (head1 == null) {
                return true;
            }
            if (root == null) {
                return false;
            }
            if (root.val == head1.val) {
                return isSubPath(root.left, head1.next) || isSubPath(root.right, head1.next);
            }
            return false;
        }
    }
}
