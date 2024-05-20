package leetcode.medium;

/**
 * @Author m1a2st
 * @Date 2023/7/14
 * @Version v1.0
 */
public class No1448 {

    class Solution {
        public int goodNodes(TreeNode root) {
            return goodNodes(root, Integer.MIN_VALUE);
        }

        private int goodNodes(TreeNode root, int max) {
            if (root == null) return 0;
            final int newMax = Math.max(max, root.val);
            return (root.val >= max ? 1 : 0) + goodNodes(root.left, newMax) + goodNodes(root.right, newMax);
        }
    }
}
