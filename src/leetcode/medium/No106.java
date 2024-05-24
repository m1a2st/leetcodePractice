package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class No106 {


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

        Map<Integer, Integer> inToIndex = new HashMap<>();

        public TreeNode buildTree(int[] inorder, int[] postorder) {

            for (int i = 0; i < inorder.length; ++i)
                inToIndex.put(inorder[i], i);

            return build(0, inorder.length - 1, postorder, 0, postorder.length - 1);
        }

        TreeNode build(int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
            if (inStart > inEnd)
                return null;

            final int rootVal = postorder[postEnd];
            final int rootInIndex = inToIndex.get(rootVal);
            final int leftSize = rootInIndex - inStart;

            TreeNode root = new TreeNode(rootVal);
            root.left = build(inStart, rootInIndex - 1, postorder, postStart, postStart + leftSize - 1);
            root.right = build(rootInIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);
            return root;
        }
    }
}
