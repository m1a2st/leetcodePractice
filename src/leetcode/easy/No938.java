package leetcode.easy;

public class No938 {


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

        int ans;

        public int rangeSumBST(TreeNode root, int low, int high) {
            preorder(root, low, high);
            return ans;
        }

        private void preorder(TreeNode root, int low, int high) {
            if (root == null) {
                return;
            }
            int val = root.val;
            if (val >= low && val <= high) {
                ans += val;
            }
            if (val < high) {
                preorder(root.right, low, high);
            }
            if (val > low) {
                preorder(root.left, low, high);
            }
        }
    }
}
