package leecode.easy;

/**
 * @Author m1a2st
 * @Date 2023/7/10
 * @Version v1.0
 */
public class No572 {

    class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null)
                return false;
            if (isSameTree(s, t))
                return true;
            return isSubtree(s.left, t) || isSubtree(s.right, t);
        }

        private boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null)
                return p == q;
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
