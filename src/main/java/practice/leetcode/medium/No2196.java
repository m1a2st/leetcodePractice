package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class No2196 {


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
        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<TreeNode, TreeNode> childToParent = new HashMap<>();
            Map<Integer, TreeNode> valToNode = new HashMap<>();

            for (int[] d : descriptions) {
                final int p = d[0];
                final int c = d[1];
                final int isLeft = d[2];
                TreeNode parent = valToNode.getOrDefault(p, new TreeNode(p));
                TreeNode child = valToNode.getOrDefault(c, new TreeNode(c));
                valToNode.put(p, parent);
                valToNode.put(c, child);
                childToParent.put(child, parent);
                if (isLeft == 1)
                    parent.left = child;
                else
                    parent.right = child;
            }

            // Pick a random node and traverse upwardly.
            TreeNode root = childToParent.keySet().iterator().next();
            while (childToParent.containsKey(root))
                root = childToParent.get(root);
            return root;
        }
    }
}
