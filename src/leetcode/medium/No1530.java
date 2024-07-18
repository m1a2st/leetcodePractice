package leetcode.medium;

import org.junit.jupiter.api.Test;

public class No1530 {
    
    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);
        TreeNode lr = new TreeNode(5);
        TreeNode rl = new TreeNode(6);
        TreeNode rr = new TreeNode(7);
        root.left = l;
        root.right = r;
        l.left = ll;
        l.right = lr;
        r.right = rr;
        System.out.println(new Solution().countPairs(root, 3));
    }


    class Solution {

        private int ans = 0;
        
        public int countPairs(TreeNode root, int distance) {
            dfs(root, distance);

            return ans;
        }
        
        private int[] dfs(TreeNode root, int distance) {
            int[] d = new int[distance + 1]; // {distance: the number of leaf nodes}
            if (root == null)
                return d;
            if (root.left == null && root.right == null) {
                d[0] = 1;
                return d;
            }

            int[] dl = dfs(root.left, distance);
            int[] dr = dfs(root.right, distance);

            for (int i = 0; i < distance; ++i)
                for (int j = 0; j < distance; ++j)
                    if (i + j + 2 <= distance)
                        ans += dl[i] * dr[j];

            for (int i = 0; i < distance; ++i)
                d[i + 1] = dl[i] + dr[i];

            return d;
        }
    }
}
