package practice.lintcode.medium;

import java.util.ArrayDeque;
import java.util.Queue;

public class No854 {

    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public class Solution {


        /**
         * @param root: the root
         * @param k:    an integer
         * @return: the value of the nearest leaf node to target k in the tree
         */
        public int findClosestLeaf(TreeNode root, int k) {
            TreeNode target = findTarget(root, k);
            return findClosestLeaf(root);
        }

        private int findClosestLeaf(TreeNode root) {
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                for (int i = 0; i < queue.size(); i++) {
                    TreeNode node = queue.poll();
                    if (node.left == null && node.right == null) {
                        return node.val;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }
                }
            }
            return root.val;
        }

        private TreeNode findTarget(TreeNode root, int k) {
            if (root == null) {
                return null;
            }
            if (root.val == k) {
                return root;
            }
            TreeNode left = findTarget(root.left, k);
            TreeNode right = findTarget(root.right, k);
            return left == null ? right : left;
        }
    }
}

