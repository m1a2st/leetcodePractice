package parctice.leetcode.medium;

public class No337 {

    class T {
        public int robRoot;
        public int notRobRoot;

        public T(int robRoot, int notRobRoot) {
            this.robRoot = robRoot;
            this.notRobRoot = notRobRoot;
        }
    }

    class Solution {
        public int rob(TreeNode root) {
            T t = robOrNotRob(root);
            return Math.max(t.robRoot, t.notRobRoot);
        }

        private T robOrNotRob(TreeNode root) {
            if (root == null) {
                return new T(0, 0);
            }
            T l = robOrNotRob(root.left);
            T r = robOrNotRob(root.right);
            return new T(root.val + l.notRobRoot + r.notRobRoot,
                    Math.max(l.robRoot, l.notRobRoot) + Math.max(r.robRoot, r.notRobRoot));
        }
    }

    public class SolutionNew {
        public int rob(TreeNode root) {
            int[] num = dfs(root);
            return Math.max(num[0], num[1]);
        }

        private int[] dfs(TreeNode x) {
            if (x == null) return new int[2];
            int[] left = dfs(x.left);
            int[] right = dfs(x.right);
            int[] res = new int[2];
            res[0] = left[1] + right[1] + x.val;
            res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return res;
        }
    }
}
