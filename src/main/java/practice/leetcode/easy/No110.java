package practice.leetcode.easy;

/**
 * @Author m1a2st
 * @Date 2023/7/8
 * @Version v1.0
 */
public class No110 {

    class Solution {
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            return Math.abs(findHeight(root.left) - findHeight(root.right)) <= 1 && // 最高子樹
                    isBalanced(root.left) && // 遞迴求解左子樹
                    isBalanced(root.right); // 遞迴求解右子數
        }

        private int findHeight(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(findHeight(root.left), findHeight(root.right));
        }
    }

    class SolutionNew {
        public boolean isBalanced(TreeNode root) {
            if (root == null) {
                return true;
            }
            return height(root) != -1;
        }

        private int height(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int lHeight = height(root.left);
            int rHeight = height(root.right);

            if (lHeight == -1 || rHeight == -1) return -1;
            if (Math.abs(lHeight - rHeight) > 1) return -1;
            return 1 + Math.max(lHeight, rHeight);
        }
    }

}
