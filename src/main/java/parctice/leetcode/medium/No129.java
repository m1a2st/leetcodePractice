package main.java.parctice.leetcode.medium;

import org.junit.jupiter.api.Test;

public class No129 {

    @Test
    public void testSumNumbers() {
        Solution solution = new Solution();
        assert solution.sumNumbers(new TreeNode(1, new TreeNode(2), new TreeNode(3))) == 25;
        assert solution.sumNumbers(new TreeNode(4, new TreeNode(9, new TreeNode(5), new TreeNode(1)), new TreeNode(0))) == 1026;
    }

    class Solution {
        public int sumNumbers(TreeNode root) {
            return dfs(root, 0);
        }

        private int dfs(TreeNode root, int pathVal) {
            if (root == null) {
                return 0;
            }
            int pathSum = pathVal * 10 + root.val;
            int sum = 0;
            if (root.left == null && root.right == null) {
                sum += pathSum;
            }
            sum += dfs(root.right, pathSum);
            sum += dfs(root.left, pathSum);
            return sum;
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

    class SolutionBT {

        int ans = 0;
        int temp = 0;

        public int sumNumbers(TreeNode root) {
            if (root == null) {
                return 0;
            }
            traversal(root);
            return ans;
        }

        private void traversal(TreeNode root) {
            if (root == null) {
                return;
            }
            temp = temp * 10 + root.val;
            if (root.left == null && root.right == null) {
                ans += temp;
            } else {
                traversal(root.left);
                traversal(root.right);
            }
            temp = temp / 10;
        }
    }
}
