package practice.leetcode.easy;

/**
 * @Author m1a2st
 * @Date 2023/7/7
 * @Version v1.0
 */
public class No543 {

    class Solution {
        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return ans;
        }

        private int ans = 0;

        int maxDepth(TreeNode root) {
            if (root == null)
                return 0;

            final int l = maxDepth(root.left);
            final int r = maxDepth(root.right);
            ans = Math.max(ans, l + r);
            return 1 + Math.max(l, r);
        }
    }

    class SolutionNew {

        int ans;

        public int diameterOfBinaryTree(TreeNode root) {
            maxDepth(root);
            return ans;
        }

        private int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int left = maxDepth(root.left);
            int right = maxDepth(root.left);
            ans = Math.max(ans, left + right);
            return 1 + Math.max(left, right);
        }
    }
}
