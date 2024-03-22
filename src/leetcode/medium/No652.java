package leetcode.medium;

import java.util.*;

public class No652 {


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

        List<TreeNode> ans = new ArrayList<>();
        Map<String, Integer> count = new HashMap<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            encode(root);
            return ans;
        }

        private String encode(TreeNode root) {
            if (root == null) {
                return "";
            }

            final String encoded = root.val + "#" + encode(root.left) + "#" + encode(root.right);
            if (count.merge(encoded, 1, Integer::sum) == 2) {
                ans.add(root);
            }
            return encoded;
        }
    }

    class SolutionNew {

        List<TreeNode> ans = new ArrayList<>();
        Map<String, Integer> cache = new HashMap<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            encode(root);
            return ans;
        }

        private String encode(TreeNode root) {
            if (root == null) {
                return "";
            }
            String encoded = root.val + "#" + encode(root.right) + "#" + encode(root.left);
            if (cache.merge(encoded, 1, Integer::sum) == 2) {
                ans.add(root);
            }
            return encoded;
        }
    }
}
