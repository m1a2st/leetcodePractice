package practice.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class No2458 {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    class Solution {

        // valToMaxHeight[val] := the maximum height without the node with `val`
        private final Map<Integer, Integer> valToMaxHeight = new HashMap<>();
        // valToHeight[val] := the height of the node with `val`
        private final Map<Integer, Integer> valToHeight = new HashMap<>();
        
        public int[] treeQueries(TreeNode root, int[] queries) {
            int[] ans = new int[queries.length];

            dfs(root, 0, 0);

            for (int i = 0; i < queries.length; ++i)
                ans[i] = valToMaxHeight.get(queries[i]);

            return ans;
        }

        private int height(TreeNode root) {
            if (root == null)
                return 0;
            if (valToHeight.containsKey(root.val))
                return valToHeight.get(root.val);
            final int h = 1 + Math.max(height(root.left), height(root.right));
            valToHeight.put(root.val, h);
            return h;
        }

        // maxHeight := the maximum height without the current node `root`
        private void dfs(TreeNode root, int depth, int maxHeight) {
            if (root == null)
                return;
            valToMaxHeight.put(root.val, maxHeight);
            dfs(root.left, depth + 1, Math.max(maxHeight, depth + height(root.right)));
            dfs(root.right, depth + 1, Math.max(maxHeight, depth + height(root.left)));
        }
    }
}
