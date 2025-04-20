package practice.leetcode.easy;

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

    class SolutionNew {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if (s == null) {
                return false;
            }
            if (isSameTree(s, t)) {
                return true;
            }
            return isSubtree(s.right, t) || isSubtree(s.left, t);
        }

        public boolean isSameTree(TreeNode s, TreeNode t) {
            if (s == null && t == null) {
                return true;
            } else if (s == null || t == null) {
                return false;
            }
            return s.val == t.val && isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
    }
}
