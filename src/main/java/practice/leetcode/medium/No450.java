package practice.leetcode.medium;

public class No450 {


    //      Definition for a binary tree node.
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
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) {
                return null;
            }
            if (root.val == key) {
                if (root.right == null) {
                    return root.left;
                }
                if (root.left == null) {
                    return root.right;
                }
                TreeNode minNode = getMin(root.right);
                root.right = deleteNode(root.right, minNode.val);
                minNode.left = root.left;
                minNode.right = root.right;
                root = minNode;
            } else if (root.val > key) {
                root.left = deleteNode(root.left, key);
            } else if (root.val < key) {
                root.right = deleteNode(root.right, key);
            }


            return root;
        }

        private TreeNode getMin(TreeNode root) {
            while (root.left != null) {
                root = root.left;
            }
            return root;
        }
    }
}
