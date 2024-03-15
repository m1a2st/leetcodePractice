package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class No662 {


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
        public int widthOfBinaryTree(TreeNode root) {
            if (root == null)
                return 0;

            int ans = 0;
            Deque<Pair> q = new ArrayDeque<>(); // {node, index}
            q.offer(new Pair(root, 1));

            while (!q.isEmpty()) {
                int offset = q.peekFirst().value * 2;
                ans = Math.max(ans, q.peekLast().value - q.peekFirst().value + 1);
                for (int sz = q.size(); sz > 0; --sz) {
                    TreeNode node = q.peekFirst().key;
                    int index = q.pollFirst().value;
                    if (node.left != null)
                        q.offer(new Pair(node.left, index * 2 - offset));
                    if (node.right != null)
                        q.offer(new Pair(node.right, index * 2 + 1 - offset));
                }
            }
            return ans;
        }

        class Pair {
            TreeNode key;
            int value;

            public Pair(TreeNode key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }
}
