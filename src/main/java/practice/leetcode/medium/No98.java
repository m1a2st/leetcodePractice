package practice.leetcode.medium;

/**
 * @Author m1a2st
 * @Date 2023/7/15
 * @Version v1.0
 */
public class No98 {

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, null, null);
        }

        private boolean isValidBST(TreeNode root, TreeNode minNode, TreeNode maxNode) {
            if (root == null) {
                return true;
            }
            if (minNode != null && root.val <= minNode.val) {
                return false;
            }
            if (maxNode != null && root.val >= maxNode.val) {
                return false;
            }

            return isValidBST(root.left, minNode, root) && isValidBST(root.right, root, maxNode);
        }
    }
}
