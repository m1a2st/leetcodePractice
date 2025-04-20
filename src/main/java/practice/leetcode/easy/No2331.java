package practice.leetcode.easy;

public class No2331 {


    //      Definition for a binary tree node.
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

        boolean[] booleanDic = new boolean[]{false, true};


        public boolean evaluateTree(TreeNode root) {
            if (root.left == null && root.right == null) {
                return booleanDic[root.val];
            }

            if (root.val == 2) {
                return evaluateTree(root.left) || evaluateTree(root.right);
            } else if (root.val == 3) {
                return evaluateTree(root.left) && evaluateTree(root.right);
            } else {
                return booleanDic[root.val];
            }
        }
    }
}
