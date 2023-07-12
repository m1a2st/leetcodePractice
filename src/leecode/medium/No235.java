package leecode.medium;

/**
 * @Author m1a2st
 * @Date 2023/7/11
 * @Version v1.0
 */
public class No235 {

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 都在左子樹
            if (root.val > Math.max(p.val, q.val)) {
                return lowestCommonAncestor(root.left, p, q);
            }
            // 都在右子樹
            if (root.val < Math.min(p.val, q.val)) {
                return lowestCommonAncestor(root.right, p, q);
            }
            return root;
        }
    }
}
