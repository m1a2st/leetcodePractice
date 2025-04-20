package practice.leetcode.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class No701 {

    @Test
    void insertIntoEmptyBST() {
        No701.Solution solution = new No701().new Solution();
        TreeNode root = null;
        TreeNode result = solution.insertIntoBST(root, 5);
        assertEquals(5, result.val);
    }

    @Test
    void insertIntoNonEmptyBST() {
        No701.Solution solution = new No701().new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        TreeNode result = solution.insertIntoBST(root, 7);
        assertEquals(7, result.left.right.val);
    }

    @Test
    void insertIntoBSTWithExistingValue() {
        No701.Solution solution = new No701().new Solution();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        TreeNode result = solution.insertIntoBST(root, 15);
        assertEquals(15, result.right.right.val);
    }

    class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }

    class SolutionNew {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (root.val > val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }
}
