package parctice.leetcode.easy;

public class No617 {


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

    class SolutionNew {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            return traversal(root1, root2);
        }

        private TreeNode traversal(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            }
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }
            return new TreeNode(root1.val + root2.val,
                    traversal(root1.left, root2.left),
                    traversal(root1.right, root2.right));
        }
    }

    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            }
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }
            TreeNode head = new TreeNode(root1.val + root2.val);
            head.right = mergeTrees(root1.right, root2.right);
            head.left = mergeTrees(root1.left, root2.left);
            return head;
        }
    }
}
