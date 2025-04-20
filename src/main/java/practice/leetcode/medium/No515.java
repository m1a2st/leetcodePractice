package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class No515 {

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
        
        List<Integer> ans = new ArrayList<>();
        
        public List<Integer> largestValues(TreeNode root) {
            dfs(root, 0);
            return ans;
        }

        private void dfs(TreeNode root, int i) {
            if (root == null) {
                return;
            }
            if (ans.size() == i) {
                ans.add(root.val);
            } else {
                ans.set(i, Math.max(ans.get(i), root.val));
                
            }
            dfs(root.left, i + 1);
            dfs(root.right, i + 1);
        }
    }
}
