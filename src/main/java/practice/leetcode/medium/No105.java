package practice.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class No105 {

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

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            for (int i = 0; i < inorder.length; ++i) {
                inToIndex.put(inorder[i], i);
            }

            return build(preorder, 0, preorder.length - 1, 0);
        }

        /**
         *
         * @param preStart 前序遍歷的起始索引
         * @param preEnd  前序遍歷的結束索引
         * @param inStart 中序遍歷的起始索引
         */
        private TreeNode build(int[] preorder, int preStart, int preEnd, int inStart) {
            // 終止條件為 前序遍歷的索引大於前序遍歷的長度
            if (preStart > preEnd) {
                return null;
            }
            // 前序遍歷的第一個節點為根節點
            final int rootVal = preorder[preStart];
            // 根節點在中序遍歷的索引
            final int rootInIndex = inToIndex.get(rootVal);
            // 左子樹的節點數量
            final int leftSize = rootInIndex - inStart;

            TreeNode root = new TreeNode(rootVal);
            root.left = build(preorder, preStart + 1, preStart + leftSize, inStart);
            root.right = build(preorder, preStart + leftSize + 1, preEnd, rootInIndex + 1);

            return root;
        }
    }

}
