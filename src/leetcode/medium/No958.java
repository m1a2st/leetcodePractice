package leetcode.medium;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No958 {

    @Test
    public void test0() {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3, new TreeNode(4), new TreeNode(5));
        root.left.left = new TreeNode(6);
        System.out.println(solution.isCompleteTree(root));
    }

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
        public boolean isCompleteTree(TreeNode root) {
            if (root == null)
                return true;

            Queue<TreeNode> q = new LinkedList<>(List.of(root));

            while (q.peek() != null) {
                TreeNode node = q.poll();
                q.offer(node.left);
                q.offer(node.right);
            }

            while (!q.isEmpty() && q.peek() == null){
                q.poll();
            }

            return q.isEmpty();
        }
    }
}
