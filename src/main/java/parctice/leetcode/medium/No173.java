package parctice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No173 {


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

    class BSTIterator {

        private int i = 0;
        private final List<Integer> vals = new ArrayList<>();

        public BSTIterator(TreeNode root) {
            inorder(root);
        }

        public int next() {
            return vals.get(i++);
        }

        public boolean hasNext() {
            return i < vals.size();
        }

        private void inorder(TreeNode root) {
            if (root == null)
                return;
            inorder(root.left);
            vals.add(root.val);
            inorder(root.right);
        }
    }
}
