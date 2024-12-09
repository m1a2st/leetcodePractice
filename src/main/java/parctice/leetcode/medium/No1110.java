package parctice.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No1110 {

    class SolutionP {

        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> delNodes = new HashSet<>();

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            for (int i : to_delete) {
                delNodes.add(i);
            }
            dfs(root, true);
            return ans;
        }

        private TreeNode dfs(TreeNode root, boolean isRoot) {
            if (root == null) {
                return null;
            }
            boolean deleted = delNodes.contains(root.val);
            if (isRoot && !deleted) {
                ans.add(root);
            }
            root.left = dfs(root.left, deleted);
            root.right = dfs(root.right, deleted);
            return deleted ? null : root;
        }
    }

    class Solution {

        List<TreeNode> ans = new ArrayList<>();
        Set<Integer> toDeleteSet = new HashSet<>();

        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            for (int i : to_delete) {
                toDeleteSet.add(i);
            }
            dfs(root, true);
            return ans;
        }

        private TreeNode dfs(TreeNode root, boolean isRoot) {
            if (root == null)
                return null;

            boolean deleted = toDeleteSet.contains(root.val);
            if (isRoot && !deleted) {
                ans.add(root);
            }

            // If root is deleted, both children have the possibility to be a new root
            root.left = dfs(root.left, deleted);
            root.right = dfs(root.right, deleted);
            return deleted ? null : root;
        }
    }
}
