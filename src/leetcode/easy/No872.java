package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class No872 {


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

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        public boolean leafSimilar(TreeNode root1, TreeNode root2) {
            traversal(root1, list1);
            traversal(root2, list2);
            return list1.equals(list2);
        }

        private void traversal(TreeNode root, List<Integer> list) {
            if (root == null) {
                return;
            }
            if (root.left == null && root.right == null) {
                list.add(root.val);
                return;
            }
            traversal(root.right, list);
            traversal(root.left, list);
        }

    }
}
