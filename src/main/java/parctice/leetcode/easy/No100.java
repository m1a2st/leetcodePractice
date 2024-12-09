package main.java.parctice.leetcode.easy;

/**
 * @Author m1a2st
 * @Date 2023/7/9
 * @Version v1.0
 */
public class No100 {

    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            // 1. 都為空
            if (p == null && q == null) return true;
            // 2. 一個為空
            if (p == null || q == null) return false;
            // 3. 值不相等
            if (p.val != q.val) return false;
            // 4. 遞迴求解
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    class SolutionNew {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            }
            if (p == null || q == null) {
                return false;
            }
            if (p.val != q.val) {
                return false;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}
