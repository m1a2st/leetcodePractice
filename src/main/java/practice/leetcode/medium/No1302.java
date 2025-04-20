package practice.leetcode.medium;

public class No1302 {

    class Solution {

        int sum = 0;
        int maxLevel = 0;

        public int deepestLeavesSum(TreeNode root) {
            dfs(root, 0);
            return sum;
        }

        private void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (root.right == null && root.left == null) {
                if (maxLevel < level) {
                    maxLevel = level;
                    sum = 0;
                    sum += root.val;
                } else if (level == maxLevel) {
                    sum += root.val;
                }
            }
            dfs(root.right, level + 1);
            dfs(root.left, level + 1);

        }
    }
}
