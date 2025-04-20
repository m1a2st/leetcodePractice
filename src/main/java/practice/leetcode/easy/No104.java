package practice.leetcode.easy;

/**
 * @Author m1a2st
 * @Date 2023/7/6
 * @Version v1.0
 */
public class No104 {

    /**
     * 1. 使用遞迴的方式找到左右子樹的最大深度
     * 2. 當左右子樹的最大深度都找到後，取最大的深度加上當前節點的深度
     */
    class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    /**
     * 1. 使用前序遍歷的方式找到最大深度
     * 2. 使用一個變量來記錄最大深度
     * 3. 使用遞迴的方式找到左右子樹的最大深度
     */
    class SolutionNew {

        int ans = 0;

        public int maxDepth(TreeNode root) {
            dfs(root, 1);
            return ans;
        }

        public void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            ans = Math.max(ans, level);
            dfs(root.left, level + 1);
            dfs(root.right, level+ 1);
        }
    }
}
